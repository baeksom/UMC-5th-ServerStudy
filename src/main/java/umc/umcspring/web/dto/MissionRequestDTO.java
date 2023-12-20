package umc.umcspring.web.dto;

import lombok.Getter;

import java.time.LocalDateTime;

public class MissionRequestDTO {

    @Getter
    public static class AddMission {
        String body;
        LocalDateTime deadline;
        String reward;
        String title;
        Long restaurantId;
    }
}
