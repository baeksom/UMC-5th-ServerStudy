package umc.umcspring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.umcspring.apiPayload.code.status.ErrorStatus;
import umc.umcspring.repository.RestaurantRepository;
import umc.umcspring.service.RestaurantService.RestaurantQueryService;
import umc.umcspring.validation.annotation.ExistRestaurant;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Annotation;

@Component
@RequiredArgsConstructor
public class RestaurantExistValidator implements ConstraintValidator<ExistRestaurant, Long> {

    private final RestaurantQueryService restaurantQueryService;

    @Override
    public void initialize(ExistRestaurant constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isVaild = restaurantQueryService.isRestaurantExist(value);
        if(!isVaild){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isVaild;
    }
}
