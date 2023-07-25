package com.xyz.rewards.vo;

public class GenericResponseEntity {
    private GenericError genericError;
    private Object response;

    public GenericResponseEntity() {
    }

    public GenericResponseEntity(GenericError genericError) {
        this.genericError = genericError;
    }

    public GenericResponseEntity(Object response) {
        this.response = response;
    }

    public GenericResponseEntity(GenericError genericError, Object response) {
        this.genericError = genericError;
        this.response = response;
    }

    public GenericError getGenericError() {
        return genericError;
    }

    public void setGenericError(GenericError genericError) {
        this.genericError = genericError;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
