package umc.umcspring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umcspring.apiPayload.code.status.ErrorStatus;
import umc.umcspring.apiPayload.exception.handler.MemberHandler;
import umc.umcspring.apiPayload.exception.handler.MemberMissionHandler;
import umc.umcspring.domain.Member;
import umc.umcspring.domain.mapping.MemberMission;
import umc.umcspring.repository.MemberMissionRepository;
import umc.umcspring.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService{

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isMemberMissionExist(Long memberMissionId) {
        return memberMissionRepository.existsById(memberMissionId);
    }

}
