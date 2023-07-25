package com.xyz.rewards.vo;

import java.util.Date;

public class GenericError {

    private String error;
    private String description;
    private Date timestamp;

    public GenericError() {
    }

    public GenericError(String error, String description) {
        this.error = error;
        this.description = description;
    }

    public GenericError(String error, String description, Date timestamp) {
        this.error = error;
        this.description = description;
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
