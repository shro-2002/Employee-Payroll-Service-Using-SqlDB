package com.bridgelabs.exceptions;

public enum Errors {

    NO_SUCH_EMPLOYEE("No such employee found"), QUERY_ERROR("No such field found");

    private String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
