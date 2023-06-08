package com.example.educationalmaterialsshop.common;

import lombok.Getter;

@Getter
public enum ResponseMessage {
    SUCCESS("transaction is success"),
    ERROR_USER_NOT_FOUND("user not found"),
    ERROR_USER_ALREADY_EXIST("user already exist"),
    ERROR_USER_LIST_IS_EMPTY("userList is empty"),
    ERROR_ROLE_NOT_FOUND("role not fount"),
    ERROR_PERMISSION_NOT_FOUND("permission not fount");

    private final String message;
    ResponseMessage(String message) {
        this.message = message;
    }
}
