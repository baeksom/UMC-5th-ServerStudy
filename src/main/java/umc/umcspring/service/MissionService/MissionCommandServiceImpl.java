package umc.umcspring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umcspring.apiPayload.code.status.ErrorStatus;
import umc.umcspring.apiPayload.exception.handler.RestaurantHandler;
import umc.umcspring.domain.Mission;
import umc.umcspring.domain.Restaurant;
import umc.umcspring.repository.MissionRepository;
import umc.umcspring.repository.RestaurantRepository;
import umc.umcspring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;

    private final RestaurantRepository restaurantRepository;

    @Override
    @Transactional
    public Mission addMission(MissionRequestDTO.AddMission request) {
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        Mission newMission = Mission.builder()
                .body(request.getBody())
                .deadline(request.getDeadline())
                .reward(request.getReward())
                .title(request.getTitle())
                .restaurant(restaurant)
                .build();

        return missionRepository.save(newMission);
    }
}
