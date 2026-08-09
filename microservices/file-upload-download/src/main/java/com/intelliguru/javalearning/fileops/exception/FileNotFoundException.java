package com.intelliguru.javalearning.fileops.exception;

public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
