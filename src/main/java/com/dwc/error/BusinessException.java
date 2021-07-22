package com.dwc.error;

/**
 * 基于包装器模式的业务异常实现
 */
public class BusinessException extends Exception implements CommonError {

    private CommonError commonError;

    //直接接收EmBusinessError的传参用于构造业务异常
    public BusinessException(CommonError commonError){
        super();
        this.commonError = commonError;
    }

    //接收自定义异常信息用于构造业务异常
    public BusinessException(CommonError commonError, String errorMsg){
        super();
        this.commonError = commonError;
        this.commonError.setErrorMsg(errorMsg);
    }

    @Override
    public int getErrorCode() {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return this.commonError.getErrorMsg();
    }

    @Override
    public CommonError setErrorMsg(String msg) {
        this.commonError.setErrorMsg(msg);
        return this;
    }
}
