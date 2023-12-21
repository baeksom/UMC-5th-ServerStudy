package umc.umcspring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umcspring.apiPayload.code.status.ErrorStatus;
import umc.umcspring.apiPayload.exception.handler.MemberHandler;
import umc.umcspring.apiPayload.exception.handler.MissionHandler;
import umc.umcspring.apiPayload.exception.handler.TempHandler;
import umc.umcspring.domain.Member;
import umc.umcspring.domain.Mission;
import umc.umcspring.domain.mapping.MemberMission;
import umc.umcspring.repository.MemberMissionRepository;
import umc.umcspring.repository.MemberRepository;
import umc.umcspring.repository.MissionRepository;
import umc.umcspring.web.dto.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService{

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public MemberMission addMemberMission(MemberMissionRequestDTO.AddMemberMissionDTO request, Long missionId) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        if (memberMissionRepository.existsByMemberAndMission(member, mission)){
            throw new TempHandler(ErrorStatus.MEMBER_MISSION_ALREADY_EXIST);
        };

        MemberMission newMemberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();

        return memberMissionRepository.save(newMemberMission);
    }
}
