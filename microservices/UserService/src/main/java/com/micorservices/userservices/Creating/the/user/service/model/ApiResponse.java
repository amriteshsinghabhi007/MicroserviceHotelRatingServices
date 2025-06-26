package com.micorservices.userservices.Creating.the.user.service.model;

import org.springframework.http.HttpStatus;

public class ApiResponse {
    private String message;
    private String success;
    private HttpStatus status;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess(String aTrue) {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public HttpStatus getStatus(String aTrue) {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public ApiResponse(String message, String success, HttpStatus status) {
        this.message = message;
        this.success = success;
        this.status = status;
    }

    public ApiResponse() {
    }

}
