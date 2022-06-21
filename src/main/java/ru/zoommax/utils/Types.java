package ru.zoommax.utils;

import lombok.Getter;

public enum Types {
        OBJECT ((byte) 0x01),
        STRING ((byte) 0x02),
        LONG ((byte) 0x03),
        DOUBLE ((byte) 0x04),
        BOOLEAN ((byte) 0x05),
        ARRAY ((byte) 0x06);

        @Getter
        private byte Byte;
        Types(byte b) {
                this.Byte = b;
        }
}
