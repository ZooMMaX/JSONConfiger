package ru.zoommax;

import ru.zoommax.reader.JCReader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONConfiger {
    private static File config;

    public JSONConfiger(File config){
        JSONConfiger.config = config;
    }

    private static String json(){
        try {
            return new String(Files.readAllBytes(Paths.get(config.getPath())), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JCReader getReader(){
        return new JCReader(json());
    }
}
