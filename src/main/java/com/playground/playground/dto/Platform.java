package com.playground.playground.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Platform {
    MOBILE("mobile"),
    PC("pc"),
    CONSOLE("console");

    private String value;
}
