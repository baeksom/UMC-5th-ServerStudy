package umc.umcspring.web.dto;

import lombok.Getter;
import umc.umcspring.validation.annotation.ExistMember;
import umc.umcspring.validation.annotation.ExistMemberMission;
import umc.umcspring.validation.annotation.ExistRestaurant;

import javax.validation.constraints.NotNull;

public class ReviewRequestDTO {

    @Getter
    public static class AddReviewDTO{
        String body;
        @NotNull
        Float score;
        @ExistMember
        Long memberId;
        @ExistMemberMission
        Long memberMissionId;
        @ExistRestaurant
        Long restaurantId;
    }
}