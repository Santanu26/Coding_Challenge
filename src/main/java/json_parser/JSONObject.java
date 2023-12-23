package json_parser;

import java.util.HashMap;
import java.util.Map;

public class JSONObject {
    private Map<String, Object> map;
    JSONObject() {
        this.map = new HashMap<>();
    }
    void put(String key, Object value) {
        map.put(key, value);
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
