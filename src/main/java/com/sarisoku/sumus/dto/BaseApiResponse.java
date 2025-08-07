package com.sarisoku.sumus.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class BaseApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private List<String> errors;
    private LocalDateTime timestamp;
    public BaseApiResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public BaseApiResponse(boolean success, String message, T data, List<String> errors) {
        this();
        this.success = success;
        this.message = message;
        this.data = data;
        this.errors = errors;
    }



    // Başarı durumlu yanıt oluşturmak için
    public static <T> BaseApiResponse<T> ok(T data, String message) {
        return new BaseApiResponse<>(true, message, data, null);
    }

    // Hata durumlu yanıt oluşturmak için
    public static <T> BaseApiResponse<T> error(List<String> errors, String message) {
        return new BaseApiResponse<>(false, message, null, errors);
    }

}
