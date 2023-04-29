package com.monzoni.melodim_project.exception;

public class EmployeeRestException extends RuntimeException {
    public EmployeeRestException(String message) {
        super(message);
    }

    public EmployeeRestException(Throwable cause) {
        super(cause);
    }

    public EmployeeRestException(String message, Throwable cause) {
        super(message, cause);
    }
}
