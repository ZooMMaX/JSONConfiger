package ru.zoommax.utils;

class TypeGetter {
    public String getType(Object o){
        return o.getClass().getSimpleName();
    }
}
