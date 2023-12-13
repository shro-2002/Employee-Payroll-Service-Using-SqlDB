package com.bridgelabz.exceptions;

public enum Errors {

    NO_SUCH_EMPLOYEE("No such employee found"), QUERY_ERROR("Found Error while querying data");

    private String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
