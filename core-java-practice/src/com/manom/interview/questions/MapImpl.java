package com.manom.interview.questions;

import java.util.HashMap;
import java.util.Map;

public class MapImpl implements CustomMap<Integer, String>{

    private Map<Integer, String> map;
    private static int index = 0;

    MapImpl() {
        this.map = new HashMap<>();
    }
    @Override
    public void add(String element) {
        map.put(index, element);
        index++;
    }

    @Override
    public boolean remove(Integer key) {
        return false;
    }
}
