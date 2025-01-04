package com.talentofuturo.evaluacion1.calvaradoa.model;

public class ErrorResponse extends ResponseUtil {
    private int errorCode;

    public ErrorResponse(String message, int errorCode) {
        super(false, message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return "Ocurrió un error: " + getMessage();
    }
}
