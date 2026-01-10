package com.practice.jdsa.heap;

import java.util.PriorityQueue;

/**
 * Kth Largest Number
 * Problem Statement:
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 */
public class KthLargestNumber {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 3;

        int result = findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }

    public static int findKthLargest(int[] nums, int k) {
        // By default, PriorityQueue in Java is a min-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            minHeap.offer(num);
        }

        for (int i = minHeap.size(); i > k; i--) {
            minHeap.poll();
        }

        if (!minHeap.isEmpty()) {
            return minHeap.peek();
        }

        return -1;
    }
}
