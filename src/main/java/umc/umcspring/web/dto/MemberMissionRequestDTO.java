package umc.umcspring.web.dto;

import lombok.Getter;
import umc.umcspring.validation.annotation.ExistMember;

public class MemberMissionRequestDTO {

    @Getter
    public static class AddMemberMissionDTO {
        @ExistMember
        Long memberId;
    }
}
