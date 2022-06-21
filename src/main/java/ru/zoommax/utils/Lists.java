package ru.zoommax.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Lists {
    @Getter
    @Setter
    private List<String> stringList;
    @Getter
    @Setter
    private List<Long> longList;
    @Getter
    @Setter
    private List<Boolean> booleanList;
    @Getter
    @Setter
    private List<Double> doubleList;
    @Getter
    @Setter
    private List<Lists> listsList;
}
