package ru.zoommax.utils;

public class Splitters {
    public String[] splitToPair(String json){
        String separator = Character.toString(ControlChars.COMMA.getCh());
        return json.split(separator);
    }

    public String[] splitPair(String json){
        String separator = Character.toString(ControlChars.COLON.getCh());
        String[] pair = new String[2];
        pair[0] = json.substring(0, json.indexOf(separator));
        pair[1] = json.substring(json.indexOf(separator)+1);
        return pair;
    }
}
