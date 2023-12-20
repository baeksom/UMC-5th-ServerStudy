package umc.umcspring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.umcspring.apiPayload.ApiResponse;
import umc.umcspring.converter.MemberMissionConverter;
import umc.umcspring.domain.mapping.MemberMission;
import umc.umcspring.service.MemberMissionService.MemberMissionCommandService;
import umc.umcspring.web.dto.MemberMissionRequestDTO;
import umc.umcspring.web.dto.MemberMissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/{mission_id}/challenge")
    public ApiResponse<MemberMissionResponseDTO.AddMemberMissionResultDTO> join(@RequestBody @Valid MemberMissionRequestDTO.AddMemberMissionDTO request,
                                                                                @PathVariable("mission_id") Long missionId) {
        MemberMission memberMission = memberMissionCommandService.addMemberMission(request, missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toAddMemberMissionResultDTO(memberMission));
    }

}
