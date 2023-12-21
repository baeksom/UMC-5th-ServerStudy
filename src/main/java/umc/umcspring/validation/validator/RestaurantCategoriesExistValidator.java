package umc.umcspring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.umcspring.apiPayload.code.status.ErrorStatus;
import umc.umcspring.service.RestaurantCategoryService.RestaurantCategoryQueryService;
import umc.umcspring.service.RestaurantService.RestaurantCommandServiceImpl;
import umc.umcspring.validation.annotation.ExistRestaurantCategories;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RestaurantCategoriesExistValidator implements ConstraintValidator<ExistRestaurantCategories, Long> {

    private final RestaurantCategoryQueryService restaurantCommandService;
    @Override
    public void initialize(ExistRestaurantCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = restaurantCommandService.isRestaurantCategoryExist(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
