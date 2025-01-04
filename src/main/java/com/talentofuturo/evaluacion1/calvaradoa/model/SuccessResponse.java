package com.talentofuturo.evaluacion1.calvaradoa.model;

public class SuccessResponse extends ResponseUtil {
	
    public SuccessResponse(String message) {
        super(true, message);
    }

    @Override
    public String toString() {
        return "Operación exitosa: " + getMessage();
    }
}
