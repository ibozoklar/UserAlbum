package com.ihsan.useralbum.exception;

import lombok.Getter;

@Getter
public class MonolitichManagerException extends RuntimeException{
    private final ErrorType errorType;

    public MonolitichManagerException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public MonolitichManagerException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}
