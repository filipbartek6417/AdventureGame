package com.filipbartek;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final String description;
    private final Map<String, Integer> exits;

    public Location(String description, Map<String, Integer> exits) {
        this.description = description;
        this.exits = new HashMap<>(exits);
        this.exits.put("Q", 0);
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }

}
