package ru.zoommax.reader;

import org.json.JSONObject;
import ru.zoommax.Arrays;
import ru.zoommax.Types;

public class JCReader {
    private static String json;
    public JCReader(String json){
        JCReader.json = json;
    }

    public JCReader getGroup(String group){
        return new JCReader(new JSONObject(json).getJSONObject(group).toString());
    }

    public Arrays getArray(String key){
        return new Arrays(new JSONObject(json).getJSONArray(key));
    }

    public Types getItem(String key){
        return new Types(new JSONObject(json).get(key));
    }
}
