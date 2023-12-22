package umc.umcspring.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umcspring.domain.Restaurant;
import umc.umcspring.domain.Review;
import umc.umcspring.repository.RestaurantRepository;
import umc.umcspring.repository.ReviewRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantQueryServiceImpl implements RestaurantQueryService{

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public boolean isRestaurantExist(Long restaurantId) {
        return restaurantRepository.existsById(restaurantId);
    }

    @Override
    public Optional<Restaurant> findRestaurant(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long restaurantId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Page<Review> restaurantPage = reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
        return restaurantPage;
    }
}
