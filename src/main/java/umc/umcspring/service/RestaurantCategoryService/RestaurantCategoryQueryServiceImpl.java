package umc.umcspring.service.RestaurantCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umcspring.repository.RestaurantCategoryRepository;

@Service
@RequiredArgsConstructor
public class RestaurantCategoryQueryServiceImpl implements RestaurantCategoryQueryService {
    private final RestaurantCategoryRepository restaurantCategoryRepository;

    public boolean isRestaurantCategoryExist(Long categoryId){
        return restaurantCategoryRepository.existsById(categoryId);
    }
}
