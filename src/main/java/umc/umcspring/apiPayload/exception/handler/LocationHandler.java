package umc.umcspring.apiPayload.exception.handler;

import umc.umcspring.apiPayload.code.BaseErrorCode;
import umc.umcspring.apiPayload.exception.GeneralException;

public class LocationHandler extends GeneralException {
    public LocationHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
