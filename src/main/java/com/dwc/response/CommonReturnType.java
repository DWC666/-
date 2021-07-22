package com.dwc.response;

public class CommonReturnType {
    //请求的响应结果的状态：success 或 fail
    private String status;

    //若 status=success, data即为前端需要的json数据
    //若 status=fail, data即为通用错误信息
    private Object data;

    public static CommonReturnType create(Object data){
        return CommonReturnType.create(data, "success");
    }

    public static CommonReturnType create(Object data, String status){
        CommonReturnType type = new CommonReturnType();
        type.setData(data);
        type.setStatus(status);
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
