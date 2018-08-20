package net.magicreal.module.util.projectconfig;

import java.util.HashMap;
import java.util.Map;

public class JsonResult {

    private Integer status;

    private String message;

    public Map<String, Object> extend = new HashMap<String, Object>();

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static JsonResult success() {
        JsonResult voResult = new JsonResult();
        voResult.setStatus(1);
        voResult.setMessage("request success");
        return voResult;
    }

    public static JsonResult fail() {
        JsonResult voResult = new JsonResult();
        voResult.setStatus(0);
        voResult.setMessage("request fail");
        return voResult;
    }

    public static JsonResult error() {
        JsonResult voResult = new JsonResult();
        voResult.setStatus(-100);
        voResult.setMessage("request fail");
        return voResult;
    }

    public JsonResult add(String key, Object value) {
        this.extend.put(key, value);
        return this;
    }


}
