package net.terzeron.springboot.storage;

/**
 * Created by terzeron on 2017. 1. 9..
 */
public class StorageException extends RuntimeException {
    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
