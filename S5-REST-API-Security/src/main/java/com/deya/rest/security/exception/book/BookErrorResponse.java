package com.deya.rest.security.exception.book;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class BookErrorResponse {

    private int statusCode;
    private String message;
    private long timestamp;

}
