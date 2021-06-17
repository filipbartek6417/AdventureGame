package com.filipbartek;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> tempExits = new HashMap<>();
        locations.put(0, new Location("Sitting in front of the PC", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 5);
        tempExits.put("E", 3);
        tempExits.put("W", 2);
        tempExits.put("S", 4);
        locations.put(1, new Location("Standing on a narrow road at the edge of a cliff", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 5);
        locations.put(2, new Location("At the top of the hill", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("W",1);
        locations.put(3, new Location("Inside an abandoned building", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 1);
        tempExits.put("W", 2);
        locations.put(4, new Location("In a valley beside a stream", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("W", 2);
        tempExits.put("S", 1);
        locations.put(5, new Location("In the forest", tempExits));

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
        vocabulary.put("SOUTH", "S");

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0){
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits are:");
            for (String exit : exits.keySet()){
                System.out.print(exit + ", ");
            }
            System.out.println();
            String[] direction = scanner.nextLine().toUpperCase().split(" ");
            loop: {
                for (String s : direction){
                    if (s.length() > 1 && vocabulary.containsKey(s)) {
                        s = s.substring(0, 1);
                    }
                    if (exits.containsKey(s)) {
                        loc = exits.get(s);
                        break loop;
                    }
                }
                System.out.println("Please choose a valid option");
            }
        }

    }
}
