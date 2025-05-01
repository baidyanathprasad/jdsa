package com.jdsa.prep.interviews;

import java.util.Collections;
import java.util.PriorityQueue;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, This is test message!!");

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(5);
        pq.add(6);
        pq.add(10);

        while(!pq.isEmpty()) {
            Integer item = pq.poll();
            System.out.println(item);
        }
    }
}
