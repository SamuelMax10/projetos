package com.workshopmongo.demo.resource.exception;

public class StandardError {

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError(Long timestamp, Integer status, String message, String path, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.path = path;
        this.error = error;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
