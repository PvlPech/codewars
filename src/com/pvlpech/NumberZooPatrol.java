package com.pvlpech;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class NumberZooPatrol {

    public static int findMissingNumber(int[] numbers) {
        IntSummaryStatistics stat = Arrays.stream(numbers).summaryStatistics();
        if (stat.getMin() != 1) {
            return 1;
        }
        if (stat.getMax() == numbers.length) {
            return numbers.length + 1;
        }
        return (int) (((1 + stat.getMax()) * (stat.getCount() + 1) / 2) - stat.getSum());
    }

}