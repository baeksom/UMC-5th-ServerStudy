package umc.umcspring.service.MemberMissionService;

import umc.umcspring.domain.mapping.MemberMission;
import umc.umcspring.web.dto.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    public MemberMission addMemberMission(MemberMissionRequestDTO.AddMemberMissionDTO request, Long missionId);
}
