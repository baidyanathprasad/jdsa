package com.practice.jdsa.arrays.twopointers;

public class SortColors {
    public static int[] sortColors (int[] colors) {

        int start = 0, current = 0;
        int end = colors.length - 1;
        while(current <= end) {
            if (colors[current] == 0) {
                // swap colors[current] and colors[start]
                int temp = colors[start];
                colors[start] = colors[current];
                colors[current] = temp;
                start++;
                current++;
            } else if (colors[current] == 2) {
                // swap colors[current] and colors[end]
                int temp = colors[end];
                colors[end] = colors[current];
                colors[current] = temp;
                end--;
            } else {
                current++;
            }
        }
        return colors;
    }
}
