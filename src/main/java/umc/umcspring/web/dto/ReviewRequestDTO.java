package umc.umcspring.web.dto;

import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class AddReviewDTO{
        String body;
        Integer score;
        Long memberId;
        Long memberMissionId;
        Long restaurantId;
    }
}
