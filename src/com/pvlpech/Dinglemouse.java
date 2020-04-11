package com.pvlpech;

/* TV Remote */

public class Dinglemouse {

    private static final String[][] KEYBOARD = new String[][]{
            {"a", "b", "c", "d", "e", "1", "2", "3"},
            {"f", "g", "h", "i", "j", "4", "5", "6"},
            {"k", "l", "m", "n", "o", "7", "8", "9"},
            {"p", "q", "r", "s", "t", ".", "@", "0"},
            {"u", "v", "w", "x", "y", "z", "_", "/"}
    };

    public static int tvRemote(final String word) {
        for(int i = 0; i < KEYBOARD.length; i++){
            for(int j = 0; j < KEYBOARD[0].length; j++){
                System.out.print(KEYBOARD[i][j]);
            }
            System.out.print("\n");
        }
        return 1;
    }

}