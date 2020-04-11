package com.pvlpech;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* Parse bank account number */

public class BankAccount {

    private static Map<String, Long> map = new HashMap() {{
        put("     |  |", 1L);
        put(" _  _||_ ", 2L);
        put(" _  _| _|", 3L);
        put("   |_|  |", 4L);
        put(" _ |_  _|", 5L);
        put(" _ |_ |_|", 6L);
        put(" _   |  |", 7L);
        put(" _ |_||_|", 8L);
        put(" _ |_| _|", 9L);
        put(" _ | ||_|", 0L);
    }};

    public static long parse(final String acctNbr) {
        String[][] arr = Arrays.stream(acctNbr.split("\n"))
                .map(e -> Arrays.stream(e.split("(?<=\\G.{3})"))
                    .toArray(String[]::new))
                .toArray(String[][]::new);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr[0].length; i++) result.append(map.get(arr[0][i] + arr[1][i] + arr[2][i]));
        return Long.parseLong(result.toString());

    }

}