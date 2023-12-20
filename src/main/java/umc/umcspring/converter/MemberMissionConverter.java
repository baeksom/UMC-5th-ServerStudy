package umc.umcspring.converter;

import umc.umcspring.domain.mapping.MemberMission;
import umc.umcspring.web.dto.MemberMissionRequestDTO;
import umc.umcspring.web.dto.MemberMissionResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {

    public static MemberMissionResponseDTO.AddMemberMissionResultDTO toAddMemberMissionResultDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.AddMemberMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
