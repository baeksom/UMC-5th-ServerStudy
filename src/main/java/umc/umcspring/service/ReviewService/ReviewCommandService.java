package umc.umcspring.service.ReviewService;

import umc.umcspring.domain.Review;
import umc.umcspring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    public Review addReview(ReviewRequestDTO.AddReviewDTO request);
}
