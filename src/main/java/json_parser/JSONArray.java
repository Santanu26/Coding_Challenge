package json_parser;

import java.util.ArrayList;
import java.util.List;

public class JSONArray {

    private List<Object> arr;

    JSONArray() {
        this.arr = new ArrayList<>();
    }
    void add(Object value) {
        this.arr.add(value);
    }

    @Override
    public String toString() {
        return this.arr.toString();
    }
}
