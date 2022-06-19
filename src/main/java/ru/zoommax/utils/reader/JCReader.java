package ru.zoommax.utils.reader;

import ru.zoommax.utils.JSONpreparation;
import ru.zoommax.utils.Splitters;

import java.util.ArrayList;
import java.util.List;

public class JCReader {
    public void read(String json){
        String prepared = new JSONpreparation().prepare(json);
        Splitters splitters = new Splitters();
        String[] pairs = splitters.splitToPair(prepared);
        List<String[]> keyval = new ArrayList<>();
        for (String pair : pairs){
            String[] kv = splitters.splitPair(pair);
            keyval.add(kv);
        }
    }
}
