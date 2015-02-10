package com.parse.starter;

/**
 * Created by Caleb on 2/10/2015.
 */
public class InvalidValueException extends Exception {

    public InvalidValueException(String message) {
        super(message);
    }

    public InvalidValueException() {
        super();
    }
}
