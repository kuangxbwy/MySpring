package com.zju.springboot.rest;

import lombok.Data;

/**
 * @author 况祥彬
 * @date 2020/11/15 11:13
 **/
@Data
public class AjaxResponse {
    private boolean isok;
    private int code;
    private String message;
    private Object data;

    public static AjaxResponse success() {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        return resultBean;
    }

    public static AjaxResponse success(Object data) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        resultBean.setData(data);
        return resultBean;
    }
}
