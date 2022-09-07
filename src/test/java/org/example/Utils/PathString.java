package org.example.Utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PathString {

    SITE_URL("https://catfact.ninja/"),
    CAT_PATH("facts"),
    CAT_PATH_FOR_RANDOM_SEARCH("fact"),
    BREED_PATH("breeds");

    private final String path;
}
