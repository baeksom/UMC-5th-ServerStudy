package umc.umcspring.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umcspring.apiPayload.code.status.ErrorStatus;
import umc.umcspring.apiPayload.exception.handler.LocationHandler;
import umc.umcspring.apiPayload.exception.handler.RestaurantCategoryHandler;
import umc.umcspring.converter.RestaurantConverter;
import umc.umcspring.domain.Location;
import umc.umcspring.domain.Restaurant;
import umc.umcspring.domain.RestaurantCategory;
import umc.umcspring.repository.LocationRepository;
import umc.umcspring.repository.RestaurantCategoryRepository;
import umc.umcspring.repository.RestaurantRepository;
import umc.umcspring.web.dto.RestaurantRequestDTO;

import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;

    private final RestaurantCategoryRepository restaurantCategoryRepository;

    private final LocationRepository locationRepository;

    // 해당 ID의 RestaurantCategory가 존재하는지 확인하는 메서드
    public boolean doesRestaurantCategoryExist(Long categoryId) {
        return restaurantCategoryRepository.existsById(categoryId);
    }

    // 해당 ID의 Location이 존재하는지 확인하는 메서드
    public boolean doesLocationExist(Long categoryId) {
        return restaurantRepository.existsById(categoryId);
    }
    @Override
    @Transactional
    public Restaurant addRestaurant(RestaurantRequestDTO.AddRestaurantDTO request) {

        Restaurant newRestaurant = RestaurantConverter.toRestaurant(request);

        RestaurantCategory restaurantCategory = restaurantCategoryRepository.findById(request.getCategory())
                .orElseThrow(() -> new RestaurantCategoryHandler(ErrorStatus.RESTAURANT_CATEGORY_NOT_FOUND));

        Location location = locationRepository.findById(request.getLocation())
                .orElseThrow(() -> new LocationHandler(ErrorStatus.LOCATION_NOT_FOUND));

        newRestaurant = Restaurant.builder()
                .name(newRestaurant.getName())
                .address(newRestaurant.getAddress())
                .category(restaurantCategory)
                .location(location)
                .build();
        // 그럼 굳이 컨버터에서 먼저 객체를 생성해줄 필요가 있나? 그냥 여기서 생성하면 안되는건가?

        return restaurantRepository.save(newRestaurant);
    }
}
