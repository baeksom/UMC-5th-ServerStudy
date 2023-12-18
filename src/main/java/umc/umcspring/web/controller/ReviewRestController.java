package umc.umcspring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.umcspring.apiPayload.ApiResponse;
import umc.umcspring.converter.ReviewConverter;
import umc.umcspring.domain.Review;
import umc.umcspring.service.ReviewService.ReviewCommandService;
import umc.umcspring.web.dto.ReviewRequestDTO;
import umc.umcspring.web.dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/restaurant/review/")
    private ApiResponse<ReviewResponseDTO.AddReviewResultDTO> join(@RequestBody @Valid ReviewRequestDTO.AddReviewDTO request) {
        Review review = reviewCommandService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResultDTO(review));
    }
}
