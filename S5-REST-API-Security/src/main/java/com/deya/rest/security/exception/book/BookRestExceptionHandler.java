package com.deya.rest.security.exception.book;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookRestExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleNotFoundBookException(BookNotFoundException bookNotFoundException) {
        BookErrorResponse bookErrorResponse = new BookErrorResponse();
        bookErrorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        bookErrorResponse.setMessage(bookNotFoundException.getMessage());
        bookErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(bookErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleExceptionBadRequestException(Exception exception) {
        BookErrorResponse bookErrorResponse = new BookErrorResponse();
        bookErrorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        bookErrorResponse.setMessage(exception.getMessage());
        bookErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(bookErrorResponse, HttpStatus.BAD_REQUEST);
    }

}
