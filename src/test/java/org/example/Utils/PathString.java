package org.example.Utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PathString {

    CAT_PATH("facts"),
    CAT_PATH_FOR_RANDOM_SEARCH("fact"),
    BREED_PATH("breeds");

    private final String path;
}
