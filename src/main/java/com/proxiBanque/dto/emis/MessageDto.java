package com.proxiBanque.dto.emis;

public class MessageDto {
    private String message;

    protected MessageDto() {
    }
    public MessageDto(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
}
