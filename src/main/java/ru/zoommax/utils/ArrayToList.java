package ru.zoommax.utils;

import java.util.ArrayList;
import java.util.List;

public class ArrayToList {
    public Lists getList(String s){
        s = new Preparations().replaceTags(s, "]");
        String[] elements = s.split(ControlChars.COMMAINARRAY.getSch());
        String type = new TypeGetter().getType(elements[0]).getClass().getSimpleName();
        Lists lists;
        switch (type){
            case "String":
                lists = new Lists();
                lists.setStringList(stringList(elements));
                return lists;
            case "Long":
                lists = new Lists();
                lists.setLongList(longList(elements));
                return lists;
            case "Boolean":
                lists = new Lists();
                lists.setBooleanList(booleanList(elements));
                return lists;
            case "Double":
                lists = new Lists();
                lists.setDoubleList(doubleList(elements));
                return lists;
            default:
                lists = new Lists();
                lists.setStringList(stringList(elements));
                return lists;

        }
    }

    private List<String> stringList(String[] elem){
        List<String> tmp = new ArrayList<>();
        for (String s : elem){

            s = s.replace(ControlChars.STARTQUOTE.getSch(), "").replace(ControlChars.ENDQUOTE.getSch(), "");
            tmp.add(s);
        }
        return tmp;
    }

    private List<Long> longList(String[] elem) {
        List<Long> tmp = new ArrayList<>();
        for (String s : elem) {
            tmp.add(Long.parseLong(s));
        }
        return tmp;
    }

    private List<Boolean> booleanList(String[] elem) {
        List<Boolean> tmp = new ArrayList<>();
        for (String s : elem) {
            tmp.add(Boolean.getBoolean(s));
        }
        return tmp;
    }

    private List<Double> doubleList(String[] elem) {
        List<Double> tmp = new ArrayList<>();
        for (String s : elem) {
            tmp.add(Double.parseDouble(s));
        }
        return tmp;
    }
}
