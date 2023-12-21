package umc.umcspring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.umcspring.apiPayload.code.status.ErrorStatus;
import umc.umcspring.repository.FoodCategoryRepository;
import umc.umcspring.service.FoodCategoryService.FoodCategoryQueryService;
import umc.umcspring.service.MemberService.MemberCommandServiceImpl;
import umc.umcspring.service.MemberService.MemberQueryService;
import umc.umcspring.validation.annotation.ExistFoodCategories;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FoodCategoriesExistValidator implements ConstraintValidator<ExistFoodCategories, List<Long>> {

    private final FoodCategoryQueryService foodCategoryQueryService;
    @Override
    public void initialize(ExistFoodCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> foodCategoryQueryService.isFoodCategoryExist(value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
