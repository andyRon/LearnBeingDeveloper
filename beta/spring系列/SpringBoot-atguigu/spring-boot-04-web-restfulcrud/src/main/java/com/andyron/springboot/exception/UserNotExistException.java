package com.andyron.springboot.exception;

/**
 * @author Andy Ron
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在");
    }
}
