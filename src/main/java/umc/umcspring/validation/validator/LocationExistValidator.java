package umc.umcspring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.umcspring.apiPayload.code.status.ErrorStatus;
import umc.umcspring.service.RestaurantService.RestaurantCommandServiceImpl;
import umc.umcspring.validation.annotation.ExistLocation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LocationExistValidator implements ConstraintValidator<ExistLocation, Long> {

    private final RestaurantCommandServiceImpl restaurantCommandService;
    @Override
    public void initialize(ExistLocation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = restaurantCommandService.doesRestaurantCategoryExist(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.LOCATION_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
