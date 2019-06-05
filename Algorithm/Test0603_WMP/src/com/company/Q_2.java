package com.company;

import java.util.HashMap;

public class Q_2 {
    public static void main(String[] args){
        HashMap map = new HashMap();
        map.put(1, "kim");
        map.put(1, "lee");
        map.put(1, "Jung");
        map.put(1, "Park");

        System.out.println(map.size());
        System.out.println(map.get(1));

    }
}
