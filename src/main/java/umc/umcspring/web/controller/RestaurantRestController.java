package umc.umcspring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.umcspring.apiPayload.ApiResponse;
import umc.umcspring.converter.RestaurantConverter;
import umc.umcspring.domain.Restaurant;
import umc.umcspring.service.RestaurantService.RestaurantCommandService;
import umc.umcspring.web.dto.RestaurantRequestDTO;
import umc.umcspring.web.dto.RestaurantResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/restaurant/")
    private ApiResponse<RestaurantResponseDTO.AddRestaurantResultDTO> join(@RequestBody @Valid RestaurantRequestDTO.AddRestaurantDTO request) {
        Restaurant restaurant = restaurantCommandService.addRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.toAddRestaurantResultDTO(restaurant));
    }
}
