package com.practice.jdsa.arrays.merge_intervals;

import java.util.HashMap;

/**
 * Problem Statement:
 * Given an array of integers nums and an integer target, return indices of the two
 * numbers such that they add up to target.
 * Examples:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;

        try {
            int[] output = calculateTarget(numbers, target);
            if (output.length == 0) {
                System.out.println("Not found");
            } else {
                System.out.println(output[0] + "," + output[1]);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int compliment = target - nums[i];
            if(map.containsKey(compliment)) {
                return new int[] {i, map.get(compliment)};
            }
            map.put(compliment, i);
        }

        throw new IllegalArgumentException("No two sum found");
    }

    public static int[] calculateTarget(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
