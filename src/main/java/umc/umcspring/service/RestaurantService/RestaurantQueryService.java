package umc.umcspring.service.RestaurantService;

import org.springframework.data.domain.Page;
import umc.umcspring.domain.Restaurant;
import umc.umcspring.domain.Review;

import java.util.Optional;

public interface RestaurantQueryService {
    public boolean isRestaurantExist(Long restaurantId);

    Optional<Restaurant> findRestaurant(Long id);

    Page<Review> getReviewList(Long restaurantId, Integer page);
}
