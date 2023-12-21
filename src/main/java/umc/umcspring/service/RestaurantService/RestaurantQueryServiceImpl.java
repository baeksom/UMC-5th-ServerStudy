package umc.umcspring.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umcspring.repository.RestaurantRepository;

@Service
@RequiredArgsConstructor
public class RestaurantQueryServiceImpl implements RestaurantQueryService{

    private final RestaurantRepository restaurantRepository;

    @Override
    public boolean isRestaurantExist(Long restaurantId) {
        return restaurantRepository.existsById(restaurantId);
    }
}
