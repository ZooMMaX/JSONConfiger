package ru.zoommax;

public class Types {
    private static Object item;

    public Types(Object item){
        Types.item = item;
    }

    public boolean toBoolean(){
        return (boolean) item;
    }

    public byte toByte(){
        return (byte) item;
    }

    public short toShort(){
        return (short) item;
    }

    public int toInt(){
        return (int) item;
    }

    public long toLong(){
        return (long) item;
    }

    public double toDouble(){
        return (double) item;
    }

    public float toFloat(){
        return (float) item;
    }

    public String toString(){
        return (String) item;
    }
}
