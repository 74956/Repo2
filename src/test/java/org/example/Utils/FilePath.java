package org.example.Utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FilePath {

    CATS_FILE_PATH("src/test/resources/ReadCats.csv"),
    BREED_FILE_PATH("src/test/resources/ReadBreeds.csv");

    private final String filePath;
}
