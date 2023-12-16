package umc.umcspring.service.MemberService;

import umc.umcspring.domain.Member;
import umc.umcspring.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinDTO request);
}
