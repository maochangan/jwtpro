package net.magicreal.module.util.projectconfig;

import java.io.Serializable;

/**
 * @author: maochangan
 * @Date: 2018/7/19 16:15
 * @Description: 通用返回类
 */
public class SerResult<T> implements Serializable {

    private boolean isSuccess;

    private String msg;

    private T value;

    private int code;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public SerResult(boolean isSuccess, T value, String msg, int code) {
        this.isSuccess = isSuccess;
        this.msg = msg;
        this.value = value;
        this.code = code;
    }

    public static <T> SerResult<T> createSuccess(T v) {
        return new SerResult<T>(true, v, SerResultCode.SUCCESS.getMsg(), SerResultCode.SUCCESS.getCode());
    }

    public static <T> SerResult<T> createSuccess(T v, String msg) {
        return new SerResult<T>(true, v, msg, SerResultCode.SUCCESS.getCode());
    }

    public static <T> SerResult<T> createFail(String msg, int rc) {
        return new SerResult<T>(false, null, msg, rc);
    }

    public static <T> SerResult<T> createFail(SerResultCode serviceResultCode) {
        return new SerResult<T>(false, null, serviceResultCode.getMsg(), serviceResultCode.getCode());
    }

    public static <T> SerResult<T> createFail() {
        return new SerResult<T>(false, null, SerResultCode.FAIL.getMsg(), SerResultCode.FAIL.getCode());
    }

    public static <T> SerResult<T> createError(String msg, int rc) {
        return new SerResult<T>(false, null, msg, rc);
    }

    public static <T> SerResult<T> createError(SerResultCode serviceResultCode) {
        return new SerResult<T>(false, null, serviceResultCode.getMsg(), serviceResultCode.getCode());
    }

    public static <T> SerResult<T> createError(String msg, int rc, T v) {
        return new SerResult<T>(false, v, msg, rc);
    }

    public static <T> SerResult<T> createError() {
        return new SerResult<T>(false, null, SerResultCode.ERROR.getMsg(), SerResultCode.ERROR.getCode());
    }


}
