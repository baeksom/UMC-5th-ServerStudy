package umc.umcspring.apiPayload.exception.handler;

import umc.umcspring.apiPayload.code.BaseErrorCode;
import umc.umcspring.apiPayload.exception.GeneralException;

public class RestaurantCategoryHandler extends GeneralException {
    public RestaurantCategoryHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
