package com.talentofuturo.evaluacion1.calvaradoa.model;

public class ResponseUtil {
	
    private final boolean status;
    private final String message;

    public ResponseUtil(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
