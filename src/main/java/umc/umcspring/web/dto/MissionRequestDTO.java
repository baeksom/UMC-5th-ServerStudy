package umc.umcspring.web.dto;

import lombok.Getter;
import umc.umcspring.validation.annotation.ExistRestaurant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class MissionRequestDTO {

    @Getter
    public static class AddMission {
        String body;
        LocalDateTime deadline;
        @NotBlank
        String reward;
        @NotBlank
        String title;
        @ExistRestaurant
        Long restaurantId;
    }
}
