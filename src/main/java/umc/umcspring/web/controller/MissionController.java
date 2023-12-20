package umc.umcspring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.umcspring.apiPayload.ApiResponse;
import umc.umcspring.converter.MissionConverter;
import umc.umcspring.domain.Mission;
import umc.umcspring.service.MissionService.MissionCommandService;
import umc.umcspring.web.dto.MissionRequestDTO;
import umc.umcspring.web.dto.MissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location/restaurant")
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/mission/")
    public ApiResponse<MissionResponseDTO.AddResultDTO> join(@RequestBody @Valid MissionRequestDTO.AddMission request){
        Mission mission = missionCommandService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddResultDTO(mission));
    }
}
