package umc.umcspring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umcspring.apiPayload.code.status.ErrorStatus;
import umc.umcspring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.umcspring.converter.MemberConverter;
import umc.umcspring.converter.MemberPreferConverter;
import umc.umcspring.domain.FoodCategory;
import umc.umcspring.domain.Member;
import umc.umcspring.domain.mapping.MemberPrefer;
import umc.umcspring.repository.FoodCategoryRepository;
import umc.umcspring.repository.MemberRepository;
import umc.umcspring.web.dto.MemberRequestDTO;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDTO request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}