package com.pvlpech;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BankAccount {

    public static String[][] parse(final String acctNbr) {
        Map<String, Integer> map = new HashMap() {{
            put("     |  |", 1);
            put(" _  _||_ ", 2);
            put(" _  _| _|", 3);
            put("   |_|  |", 4);
            put(" _ |_  _|", 5);
            put(" _ |_ |_|", 6);
            put(" _   |  |", 7);
            put(" _ |_||_|", 8);
            put(" _ |_| _|", 9);
            put(" _ | ||_|", 0);
        }};

        String[][] arr = Arrays.stream(acctNbr.split("\n"))
                .map(e -> Arrays.stream(e.split("(?<=\\G.{3})"))
                    .toArray(String[]::new))
                .toArray(String[][]::new);

        String[] tArr = new String[9];
        for (int i = 0; i < arr.length; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < arr[0].length; j++) {
                s.append(arr[i][j]);
//                System.out.print(arr[i][j]);
            }
            tArr[i] = s.toString();
//            System.out.print("\n");
        }
//
//        for (int i = 0; i < tArr.length; i++) {
//            for (int j = 0; j < tArr[0].length; j++) {
//                System.out.print(tArr[i][j]);
//            }
//            System.out.print("\n");
//        }

        long res = 0;
        for (int i = 0; i < tArr.length; i++) {
            System.out.print(tArr[i]);
            res += Math.pow(10, 10-i)*map.get(tArr[i]);

        }
        System.out.println(res);

        return arr;
    }

}