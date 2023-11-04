package com.example.neteasecloudmusic.logic.network.entities;

import java.io.Serializable;

/**
 * @Author winiymissl
 * @Date 2023-11-04 19:12
 * @Version 1.0
 */
public class BaseResult implements Serializable {
    int code;
    String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
