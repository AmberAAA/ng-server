package top.anborong.server.utils;

import java.io.Serializable;

public class ResponseDataUtils implements Serializable {

    public static <T> ResponseData buildSuccess(T data) {
        return new ResponseData<T>(ResponseEnums.SUCCESS, data);
    }

    public static ResponseData buildSuccess() {
        return new ResponseData(ResponseEnums.SUCCESS);
    }

    public static ResponseData buildError(ResponseEnums responseEnums) {
        return new ResponseData(responseEnums);
    }

    public static ResponseData buildLogicError(String str) { return new ResponseData(1, str); }

}
