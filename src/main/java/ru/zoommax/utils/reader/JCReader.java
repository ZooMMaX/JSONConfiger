package ru.zoommax.utils.reader;

import lombok.Getter;
import ru.zoommax.utils.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JCReader {

    @Getter
    private Map<String, Object> keyMap;
    @Getter
    private List<String> keys = new ArrayList<>();
    public JCReader(String json){
        this(json, "root");
    }

    public JCReader(String json, String parentKey){
        keyMap = new HashMap<>();
        String prepared = new JSONpreparation().prepare(json);
        Splitters splitters = new Splitters();
        String[] pairs = splitters.splitToPair(prepared);
        List<String[]> keyval = new ArrayList<>();
        for (String pair : pairs){
            String[] kv = splitters.splitPair(pair);
            keyval.add(kv);
        }
        for (String[] s : keyval){
            String key = parentKey+"."+new TypeGetter().getType(s[0]);
            keys.add(key);
            Object o = new TypeGetter().getType(s[1]);
            String typeName = o.getClass().getSimpleName();
            byte type;
            switch (typeName){
                case "Byte":
                    type = (byte) o;
                    break;
                case "String":
                    type = Types.STRING.getByte();
                    break;
                case "Long":
                    type = Types.LONG.getByte();
                    break;
                case "Double":
                    type = Types.DOUBLE.getByte();
                    break;
                case "Boolean":
                    type = Types.BOOLEAN.getByte();
                    break;
                case "Lists":
                    type = Types.ARRAY.getByte();
                    break;
                default:
                    type = (byte) 0x00;
                    break;
            }
            if (type > (byte) 0x00) {
                if (type <= (byte) 0x01){
                    JCReader jcReader = new JCReader(s[1], key);
                    List<String> k = jcReader.getKeys();
                    for (String kk : k){
                        key = kk;
                        if (jcReader.getKeyMap().get(key).getClass().getSimpleName().equals("ObjectMap")) {
                            ObjectMap map = (ObjectMap) jcReader.getKeyMap().get(key);
                            type = map.getType();
                            o = new ObjectMap().put(type, o);
                        }else {
                            keyMap.put(key, o);
                        }
                    }
                }else {
                    keyMap.put(key, o);
                }
            }
        }
    }
}
