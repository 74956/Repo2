package org.example.Utils;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class FileUtil {

    public static <T> List<T> convertToModel(String filePath, Class<T> modelType) {
        List<T> models;
        try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            models = new CsvToBeanBuilder(reader)
                    .withType(modelType)
                    .build()
                    .parse();
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getCause().getMessage());
        }
        return models;
    }
}
