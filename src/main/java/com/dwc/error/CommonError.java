package com.dwc.error;

public interface CommonError {
    int getErrorCode();
    String getErrorMsg();
    CommonError setErrorMsg(String msg);
}
