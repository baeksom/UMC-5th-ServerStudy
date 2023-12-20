package umc.umcspring.converter;

import umc.umcspring.domain.Mission;
import umc.umcspring.web.dto.MissionRequestDTO;
import umc.umcspring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.AddResultDTO toAddResultDTO(Mission mission) {
        return MissionResponseDTO.AddResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
