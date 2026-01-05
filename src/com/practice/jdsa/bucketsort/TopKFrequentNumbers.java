package com.practice.jdsa.bucketsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Problem: Top K Frequent Numbers
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
public class TopKFrequentNumbers {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 1;

        int[] result = topKFrequent(nums, k);
        System.out.print("Top " + k + " frequent elements are: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Find the maximum frequency
        int maxFreq = 0;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, frequencyMap.get(num));
        }

        // Step 2: Create buckets based on frequency
        List<Integer>[] buckets = new ArrayList[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int entry : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(entry);
            buckets[frequency].add(entry);
        }

        // Step 3: Collect the top k frequent elements
        int[] result = new int[k];
        int index = 0;

        for (int i = maxFreq; i >= 0 && index < k; i--) {
            for (int num : buckets[i]) {
                result[index++] = num;
                if (index == k) {
                    break;
                }
            }
        }

        return result;
    }
}
