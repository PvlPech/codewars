package com.pvlpech;

/* TV Remote */
/* TV Remote (shift and space) */
/* TV Remote (wrap) */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dinglemouse {

    private static List<List<String>> keyboard;

    private static int[] getCharPosition(String input) {
        System.out.print("getCharPosition input: " + input);
        for (List<String> row : keyboard) {
            if (row.indexOf(input) != -1) {
                System.out.println(" " + row.indexOf(input) + " : " + keyboard.indexOf(row));
                return new int[]{row.indexOf(input), keyboard.indexOf(row)};
            }
        }
        return null;
    }

    public static int tvRemote(final String word) {
        keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList("a", "b", "c", "d", "e", "1", "2", "3"));
        keyboard.add(Arrays.asList("f", "g", "h", "i", "j", "4", "5", "6"));
        keyboard.add(Arrays.asList("k", "l", "m", "n", "o", "7", "8", "9"));
        keyboard.add(Arrays.asList("p", "q", "r", "s", "t", ".", "@", "0"));
        keyboard.add(Arrays.asList("u", "v", "w", "x", "y", "z", "_", "/"));
        keyboard.add(Arrays.asList("aa", "sp", "", "", "", "", "", ""));

        int[] currentCursor = new int[]{0, 0};
        int result = 0;
        String tempWord = word;

        tempWord = tempWord.replaceAll("(.)", "|$1");
        tempWord = tempWord.replaceAll("((([a-z]|^)\\|(([_,\\.,\\@,\\/]|[0-9]| )\\|)*))(?=[A-Z])", "$1aa|");
        tempWord = tempWord.replaceAll("(([A-Z]\\|(([_,\\.,\\@,\\/]|[0-9]| )\\|)*)(?=[a-z]))", "$1aa|");
        tempWord = tempWord.replace(" ", "sp");
        System.out.println(tempWord);

        int[][] wordCharsPosition = Arrays.stream(tempWord.toLowerCase().split("\\|"))
                .filter(ch -> !ch.isEmpty())
                .map(ch -> Arrays.stream(getCharPosition(ch))
                    .toArray())
                .toArray(int[][]::new);

        for (int i = 0; i < wordCharsPosition.length; i++){
//            result += Math.abs(wordCharsPosition[i][0]-currentCursor[0]) + Math.abs(wordCharsPosition[i][1]-currentCursor[1]); // without cursor wraps
            int a = Math.min(Math.abs(wordCharsPosition[i][0] - currentCursor[0])
                    , Math.abs(keyboard.get(0).size() - Math.max(wordCharsPosition[i][0],currentCursor[0]) + Math.min(wordCharsPosition[i][0],currentCursor[0])));
            int b = Math.min(Math.abs(wordCharsPosition[i][1] - currentCursor[1])
                    , Math.abs(keyboard.size() - Math.max(wordCharsPosition[i][1],currentCursor[1]) + Math.min(wordCharsPosition[i][1],currentCursor[1])));
            result += a + b;
            currentCursor = wordCharsPosition[i];
        }

        return result + wordCharsPosition.length;
    }

}