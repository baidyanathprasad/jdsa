package com.jdsa.prep.arrays.twopointers;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.sort;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        // sort the array
        sort(nums);

        for (int i = 0; i < n; i++) {
            // skip duplicates for i
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int l = i + 1;
            int r = n - 1;

            while (l < r ) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    while(l < r && nums[r] == nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }
                else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return result;
    }
}
