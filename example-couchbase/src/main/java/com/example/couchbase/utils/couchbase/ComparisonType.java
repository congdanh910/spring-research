package com.example.couchbase.utils.couchbase;

public enum ComparisonType {

    EQ("="),
    NEQ("!="),
    GT(">"),
    GT_OR_EQ(">="),
    LT("<"),
    LT_OR_EQ("<=");

    private String operation;

    ComparisonType (String operation) {
        this.operation = operation;
    }

    public String getOperation () {
        return operation;
    }
}
