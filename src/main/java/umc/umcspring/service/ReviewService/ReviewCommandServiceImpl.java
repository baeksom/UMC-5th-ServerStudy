package umc.umcspring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umcspring.apiPayload.code.status.ErrorStatus;
import umc.umcspring.apiPayload.exception.handler.MemberHandler;
import umc.umcspring.apiPayload.exception.handler.MemberMissionHandler;
import umc.umcspring.apiPayload.exception.handler.RestaurantHandler;
import umc.umcspring.apiPayload.exception.handler.TempHandler;
import umc.umcspring.domain.Member;
import umc.umcspring.domain.Mission;
import umc.umcspring.domain.Restaurant;
import umc.umcspring.domain.Review;
import umc.umcspring.domain.mapping.MemberMission;
import umc.umcspring.repository.*;
import umc.umcspring.web.dto.ReviewRequestDTO;

import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final RestaurantRepository restaurantRepository;


    @Override
    @Transactional
    public Review addReview(ReviewRequestDTO.AddReviewDTO request) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        MemberMission memberMission = memberMissionRepository.findById(request.getMemberMissionId())
                .orElseThrow(() -> new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_NOT_FOUND));

        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        // memberId와 memberMissionId의 memberId가 같은지 확인
        if (!member.getId().equals(memberMission.getId())) {
            throw new IllegalArgumentException("memberMission의 회원과 입력의 회원 정보가 같지 않습니다.");
        }

        // restaurantId == memberMission -> missionId -> restaurantId
        if (!restaurant.getId().equals(memberMission.getMission().getRestaurant().getId())) {
            throw new IllegalArgumentException("memberMission의 레스토랑과 입력의 레스토랑 정보가 같지 않습니다.");
        };

        // 중복 체크
        if (reviewRepository.existsByMemberMission(memberMission)){
            throw new IllegalArgumentException("미션에 대한 리뷰가 이미 존재합니다.");
        };

        Review newReview = Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .member(member)
                .memberMission(memberMission)
                .restaurant(restaurant)
                .build();

        return reviewRepository.save(newReview);
    }
}
