package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {

    OK(200),
    NOT_FOUND(404);

    private final int code;

}
