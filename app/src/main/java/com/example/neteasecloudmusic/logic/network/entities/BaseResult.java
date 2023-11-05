package com.example.neteasecloudmusic.logic.network.entities;

import com.example.neteasecloudmusic.logic.network.Code;

import java.io.Serializable;

/**
 * @Author winiymissl
 * @Date 2023-11-04 19:12
 * @Version 1.0
 */
public class BaseResult implements Serializable {
    int code;
    String message;

    public boolean resultOk() {
        return Code.OK == code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
