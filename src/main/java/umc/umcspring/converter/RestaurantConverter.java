package umc.umcspring.converter;

import org.springframework.data.domain.Page;
import umc.umcspring.domain.Restaurant;
import umc.umcspring.domain.Review;
import umc.umcspring.web.dto.RestaurantRequestDTO;
import umc.umcspring.web.dto.RestaurantResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantConverter {

    public static RestaurantResponseDTO.AddRestaurantResultDTO toAddRestaurantResultDTO(Restaurant restaurant) {
        return RestaurantResponseDTO.AddRestaurantResultDTO.builder()
                .restaurantId(restaurant.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDTO.AddRestaurantDTO request){
        // description 고려 안함 (추후에 뺄 가능성 있음)
        return Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }

    public static Review toReview(RestaurantRequestDTO.ReviewDTO request){
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .body(request.getBody())
                .build();
    }

    public static RestaurantResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review){
        return RestaurantResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDate.now())
                .build();
    }

    public static RestaurantResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return RestaurantResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getNickname())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static RestaurantResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<RestaurantResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(RestaurantConverter::reviewPreViewDTO).collect(Collectors.toList());

        return RestaurantResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
