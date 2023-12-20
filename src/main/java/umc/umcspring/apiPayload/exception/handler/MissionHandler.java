package umc.umcspring.apiPayload.exception.handler;

import umc.umcspring.apiPayload.code.BaseErrorCode;
import umc.umcspring.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode errorCode) { super(errorCode);}
}

