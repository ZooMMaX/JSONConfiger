package ru.zoommax.utils;

public class JSONpreparation {
    public String prepare(String json){
        Preparations preparations = new Preparations();
        json = preparations.replaceEnter(json);
        json = preparations.replaceSpace(json);
        json = preparations.replaceQuotes(json);
        json = preparations.replaceCommaInArray(json);
        json = preparations.replaceComma(json);
        json = preparations.replaceColon(json);
        json = preparations.replaceTags(json, "}");
        return json;
    }
}
