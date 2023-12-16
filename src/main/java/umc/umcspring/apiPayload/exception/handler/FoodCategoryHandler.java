package umc.umcspring.apiPayload.exception.handler;

import umc.umcspring.apiPayload.code.BaseErrorCode;
import umc.umcspring.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
