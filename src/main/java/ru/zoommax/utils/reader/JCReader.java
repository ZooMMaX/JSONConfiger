package ru.zoommax.utils.reader;

import lombok.Getter;
import ru.zoommax.utils.*;

import java.util.*;

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
        for (String[] kv : keyval){
            String key = parentKey+"."+new TypeGetter().getType(kv[0]);
            keys.add(key);
            Object obj = new TypeGetter().getType(kv[1]);
            String type = obj.getClass().getSimpleName();
            if (type.equals("Long") || type.equals("Double") || type.equals("Boolean") ||type.equals("Lists")){
                keyMap.put(key, new ObjectMap().put(types(obj), obj));
            } else if (type.equals("String")) {
                if (obj.toString().charAt(0) == '{'){
                    JCReader jcReader = new JCReader(obj.toString());
                    List<String> l = jcReader.getKeys();
                    Map<String, Object> o = jcReader.getKeyMap();
                    for (String k : l){
                        keyMap.put(k, o.get(k));
                    }
                }else {
                    keyMap.put(key, new ObjectMap().put(types(obj), obj));
                }
            }
        }
        /*for (String[] s : keyval){
            String key = parentKey+"."+new TypeGetter().getType(s[0]);
            keys.add(key);
            Object o = new TypeGetter().getType(s[1]);
            byte type = t(o);

            while (type == (byte) 0x01) {
                JCReader jcReader = new JCReader((String) o, key);
                List<String> k = jcReader.getKeys();
                for (String kk : k) {
                    key = kk;
                    System.out.println(jcReader.getKeyMap().get(key).getClass().getSimpleName());
                    if (jcReader.getKeyMap().get(key).getClass().getSimpleName().equals("ObjectMap")) {
                        ObjectMap map = (ObjectMap) jcReader.getKeyMap().get(kk);
                        type = map.getType();
                        o = new ObjectMap().put(type, o);
                    }else {
                        keyMap.put(key, o);
                    }
                }
            }
            if (type > 0x01) {
                keyMap.put(key, o);
            }else if (type == 0x00){
                System.out.println("ERROR");
            }
        }*/
    }

    private byte types(Object o){
        String typeName = o.getClass().getSimpleName();
        byte type = 0;
        switch (typeName){
            case "String":
                if (o.toString().charAt(0) == '{'){
                    type = Types.OBJECT.getByte();
                }else {
                    type = Types.STRING.getByte();
                }
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
        return type;
    }
}
