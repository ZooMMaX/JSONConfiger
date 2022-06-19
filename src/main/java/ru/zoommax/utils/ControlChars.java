package ru.zoommax.utils;

import lombok.Getter;

public enum ControlChars {
    STARTQUOTE ((char) 0x0E60),
    ENDQUOTE ((char) 0x0E61),
    COMMA ((char) 0x0E62),
    COLON ((char) 0x0E63),
    COMMAINARRAY ((char) 0x0E64);

    @Getter
    private char ch;
    ControlChars(char ch) {
        this.ch = ch;
    }
}
