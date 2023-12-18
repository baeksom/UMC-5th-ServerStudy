package umc.umcspring.converter;

import umc.umcspring.domain.Review;
import umc.umcspring.web.dto.ReviewRequestDTO;
import umc.umcspring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.AddReviewResultDTO toAddReviewResultDTO(Review review) {
        return ReviewResponseDTO.AddReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

//    public static Review toReview(ReviewRequestDTO.AddReviewDTO request) {
//        return Review.builder()
//                .body(request.getBody())
//                .score(request.getScore())
//                .build();
//    }
}
