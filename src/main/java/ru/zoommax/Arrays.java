package ru.zoommax;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Arrays {
    private static JSONArray array;

    public Arrays(JSONArray array){
        Arrays.array = array;
    }

    public List<Boolean> getBooleanArrayToList(){
        List<Boolean> tmp = new ArrayList<>();
        for (int x = 0; x<array.length(); x++){
            tmp.add(array.getBoolean(x));
        }
        return tmp;
    }

    public List<Short> getShortArrayToList(){
        List<Short> tmp = new ArrayList<>();
        for (int x = 0; x<array.length(); x++){
            tmp.add(new Types(array.get(x)).toShort());
        }
        return tmp;
    }

    public List<Byte> getByteArrayToList(){
        List<Byte> tmp = new ArrayList<>();
        for (int x = 0; x<array.length(); x++){
            tmp.add(new Types(array.get(x)).toByte());
        }
        return tmp;
    }

    public List<Integer> getIntArrayToList(){
        List<Integer> tmp = new ArrayList<>();
        for (int x = 0; x<array.length(); x++){
            tmp.add(array.getInt(x));
        }
        return tmp;
    }

    public List<Long> getLongArrayToList(){
        List<Long> tmp = new ArrayList<>();
        for (int x = 0; x<array.length(); x++){
            tmp.add(array.getLong(x));
        }
        return tmp;
    }

    public List<Double> getDoubleArrayToList(){
        List<Double> tmp = new ArrayList<>();
        for (int x = 0; x<array.length(); x++){
            tmp.add(array.getDouble(x));
        }
        return tmp;
    }

    public List<Float> getFloatArrayToList(){
        List<Float> tmp = new ArrayList<>();
        for (int x = 0; x<array.length(); x++){
            tmp.add(array.getFloat(x));
        }
        return tmp;
    }

    public List<String> getStringArrayToList(){
        List<String> tmp = new ArrayList<>();
        for (int x = 0; x<array.length(); x++){
            tmp.add(array.getString(x));
        }
        return tmp;
    }
}
