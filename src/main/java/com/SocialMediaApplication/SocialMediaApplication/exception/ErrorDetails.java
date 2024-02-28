package com.SocialMediaApplication.SocialMediaApplication.exception;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {

    private String message;
    private String description;
    private LocalDateTime exceptionOccuredAt;

    public ErrorDetails(String message, String description, LocalDateTime exceptionOccuredAt) {
        this.message = message;
        this.description = description;
        this.exceptionOccuredAt = exceptionOccuredAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getExceptionOccuredAt() {
        return exceptionOccuredAt;
    }

    public void setExceptionOccuredAt(LocalDateTime exceptionOccuredAt) {
        this.exceptionOccuredAt = exceptionOccuredAt;
    }
}
