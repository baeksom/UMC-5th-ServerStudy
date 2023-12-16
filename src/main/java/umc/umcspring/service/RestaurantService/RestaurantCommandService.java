package umc.umcspring.service.RestaurantService;

import umc.umcspring.domain.Restaurant;
import umc.umcspring.web.dto.RestaurantRequestDTO;

public interface RestaurantCommandService {
    public Restaurant addRestaurant(RestaurantRequestDTO.AddRestaurantDTO request);
}
