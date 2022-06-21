package ru.zoommax.utils;

public class JSONpreparation {
    public String prepare(String json){
        Preparations preparations = new Preparations();
        json = preparations.replaceEnter(json);
        System.out.println(json);
        json = preparations.replaceSpace(json);
        System.out.println(json);
        json = preparations.replaceQuotes(json);
        System.out.println(json);
        json = preparations.replaceCommaInArray(json);
        System.out.println(json);
        json = preparations.replaceComma(json);
        System.out.println(json);
        json = preparations.replaceColon(json);
        System.out.println(json);
        json = preparations.replaceTags(json, "}");
        System.out.println(json);
        return json;
    }
}
