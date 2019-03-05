package com.terzeron.springboot.storage;

/**
 * Created by terzeron on 2017. 1. 9..
 */
public class StorageFileNotFoundException extends StorageException {
    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
