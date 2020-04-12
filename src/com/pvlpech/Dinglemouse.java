package com.pvlpech;

/* TV Remote */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dinglemouse {

    private static int[] getCharPosition(String input) {
        List<List<String>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList("a", "b", "c", "d", "e", "1", "2", "3"));
        keyboard.add(Arrays.asList("f", "g", "h", "i", "j", "4", "5", "6"));
        keyboard.add(Arrays.asList("k", "l", "m", "n", "o", "7", "8", "9"));
        keyboard.add(Arrays.asList("p", "q", "r", "s", "t", ".", "@", "0"));
        keyboard.add(Arrays.asList("u", "v", "w", "x", "y", "z", "_", "/"));
        for (List<String> row : keyboard) {
            if (row.indexOf(input) != -1) {
                return new int[]{keyboard.indexOf(row), row.indexOf(input)};
            }
        }
        return null;
    }

    public static int tvRemote(final String word) {
        int[] currentCursor = new int[]{0, 0};
        int result = 0;

        int[][] wordCharsPosition = Arrays.stream(word.toLowerCase().split(""))
                .map(ch -> Arrays.stream(getCharPosition(ch))
                    .toArray())
                .toArray(int[][]::new);

        for (int i = 0; i < wordCharsPosition.length; i++){
            result += Math.abs(wordCharsPosition[i][0]-currentCursor[0]) + Math.abs(wordCharsPosition[i][1]-currentCursor[1]);
            currentCursor = wordCharsPosition[i];
        }

        return result + word.length();
    }

}