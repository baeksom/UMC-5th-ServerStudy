package umc.umcspring.web.dto;

import lombok.Getter;
import umc.umcspring.validation.annotation.ExistLocation;
import umc.umcspring.validation.annotation.ExistRestaurantCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RestaurantRequestDTO {

    @Getter
    public static class AddRestaurantDTO {
        @NotBlank
        String name;
        @ExistRestaurantCategories
        Long category;
        @ExistLocation
        Long location;
        @NotNull
        String address;
    }
}
