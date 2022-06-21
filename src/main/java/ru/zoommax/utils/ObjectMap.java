package ru.zoommax.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ObjectMap {
    @Getter
    @Setter
    private List<String> keys;
    @Getter
    @Setter
    private String key;
    @Getter
    @Setter
    private byte type;
    @Getter
    @Setter
    private String stringObj;
    @Getter
    @Setter
    private Long longObj;
    @Getter
    @Setter
    private Boolean booleanObj;
    @Getter
    @Setter
    private Double doubleObj;
    @Getter
    @Setter
    private Lists listsObj;
    @Getter
    @Setter
    private List<String> stringLst;
    @Getter
    @Setter
    private List<Long> longLst;
    @Getter
    @Setter
    private List<Boolean> booleanLst;
    @Getter
    @Setter
    private List<Double> doubleLst;


    public Object put(byte type, Object o){
        ObjectMap objectMap = new ObjectMap();
        objectMap.setKey(key);
        objectMap.setType(type);
        switch (type){
            case (byte) 0x02:
                objectMap.setStringObj((String) o);
                break;
            case (byte) 0x03:
                objectMap.setLongObj((Long) o);
                break;
            case (byte) 0x04:
                objectMap.setDoubleObj((Double) o);
                break;
            case (byte) 0x05:
                objectMap.setBooleanObj((Boolean) o);
                break;
            case (byte) 0x06:
                objectMap.setListsObj((Lists) o);
                break;
        }
        return objectMap;
    }
}
