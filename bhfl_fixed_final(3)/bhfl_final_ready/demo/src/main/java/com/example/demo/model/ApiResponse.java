package com.example.demo.model;

public class ApiResponse {
    private boolean is_success;
    private String official_email;
    private Object data;

    public ApiResponse(boolean is_success, String official_email, Object data) {
        this.is_success = is_success;
        this.official_email = official_email;
        this.data = data;
    }

    public boolean isIs_success() { return is_success; }
    public String getOfficial_email() { return official_email; }
    public Object getData() { return data; }
}