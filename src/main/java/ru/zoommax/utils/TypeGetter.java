package ru.zoommax.utils;

public class TypeGetter {
    public Object getType(String s){
        String simbol = s.substring(0, 1);
        if (simbol.equalsIgnoreCase("{")){
            return Types.OBJECT.getByte();
        }
        if (simbol.equalsIgnoreCase("[")){
            return new ArrayToList().getList(s);
        }
        if (simbol.equalsIgnoreCase("f") || simbol.equalsIgnoreCase("t")){
            return Boolean.getBoolean(s);
        }
        if (simbol.equals(ControlChars.STARTQUOTE.getSch())) {
            return s.replace(ControlChars.STARTQUOTE.getSch(), "").replace(ControlChars.ENDQUOTE.getSch(), "");
        }
        for (int x = 0; x < 10; x++){
            if (simbol.equalsIgnoreCase(x+"")){
                if (s.contains(".")){
                    return Double.parseDouble(s);
                }else {
                    return Long.parseLong(s);
                }
            }
        }
        return (byte) 0x00;
    }
}
