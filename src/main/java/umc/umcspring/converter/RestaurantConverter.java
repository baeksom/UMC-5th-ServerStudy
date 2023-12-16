package umc.umcspring.converter;

import umc.umcspring.domain.Restaurant;
import umc.umcspring.web.dto.RestaurantRequestDTO;
import umc.umcspring.web.dto.RestaurantResponseDTO;

import java.time.LocalDateTime;

public class RestaurantConverter {

    public static RestaurantResponseDTO.AddRestaurantResultDTO toAddRestaurantResultDTO(Restaurant restaurant) {
        return RestaurantResponseDTO.AddRestaurantResultDTO.builder()
                .restaurantId(restaurant.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDTO.AddRestaurantDTO request){
        // description 고려 안함 (추후에 뺄 가능성 있음)
        return Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }
}
