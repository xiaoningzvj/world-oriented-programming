package com.kning.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 王康宁
 * @version 1.0
 * @date 2020/9/7
 **/
public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        result[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            result[i - k + 1] = deque.peekFirst();
        }
        return result;
    }

    public static void main(String[] args) {

        int[] ints = maxSlidingWindow(new int[]{1, 2, 3, 4, 5, 3, 2, 2, 2, 4, 9, 0, 3, 3, 4}, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
