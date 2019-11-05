package top.anborong.server.utils;

public enum ResponseEnums {

    SUCCESS(0, "请求成功"),
    LOGICERROR(1, "页面逻辑错误"),
    LOGINERROR(2, "信息失效，请重新登录。"),
    ERROR(500, "请求失败");



    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResponseEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
