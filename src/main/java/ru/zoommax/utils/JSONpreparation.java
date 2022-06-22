package ru.zoommax.utils;

public class JSONpreparation {
    public String prepare(String json){
        Preparations preparations = new Preparations();
        json = preparations.replaceTags(json, "}");
        json = preparations.replaceEnter(json);
        json = preparations.replaceSpace(json);
        json = preparations.replaceQuotes(json);
        /*json = preparations.replaceCommaInArray(json);
        System.out.println(json);
        json = preparations.replaceComma(json);*/
        json = preparations.replaceCommaa(json);
        return json;
    }
}
