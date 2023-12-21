package umc.umcspring.service.FoodCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umcspring.repository.FoodCategoryRepository;

@Service
@RequiredArgsConstructor
public class FoodCategoryQueryServiceImpl implements FoodCategoryQueryService{
    private final FoodCategoryRepository foodCategoryRepository;

    // 해당 ID의 FoodCategory가 존재하는지 확인하는 메서드
    public boolean isFoodCategoryExist(Long categoryId) {
        return foodCategoryRepository.existsById(categoryId);
    }

}
