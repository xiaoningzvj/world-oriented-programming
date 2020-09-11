package com.example.demo;

import java.util.Stack;

/**
 * @author fanhongjiang
 * @version 1.0
 * @date 2020/9/9 18:00
 */
public class GetMaxRectangleValue {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 0}

        };
        GetMaxRectangleValue value = new GetMaxRectangleValue();
        System.out.print(value.getMaxValue(arr));
    }

    int getMaxValue(int[][] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int currentMax = getPerMax(arr, i);
            max = Math.max(max, currentMax);
        }
        return max;
    }

    int getPerMax(int arr[][], int i) {
        int max = 0;
        int[] ar = new int[arr[i].length];
        //每一行的最大数
        for (int m = 0; m < ar.length; m++) {
            ar[m] = 0;
            for (int n = i; n < arr.length; n++) {
                if (arr[n][m] == 1) {
                    ar[m]++;
                } else {
                    break;
                }
            }
        }
        //推算这一行所能得到的最大面积值
        //神奇的辅助栈 总能做到我想不到的事
        Stack<Integer> stack = new Stack<>();
        for (int start = 0; start < ar.length; start++) {
            if (stack.isEmpty()) {
                stack.push(ar[start]);
                continue;
            }
            while (!stack.isEmpty() && ar[start] <= ar[stack.peek()]) {
                int currentIndex = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int j = start;
                int result = (j - k - 1) * ar[currentIndex];
                max = Math.max(result, max);
            }
            stack.push(start);
        }
        int j = ar.length;
        while (!stack.isEmpty()) {
            int currentIndex = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int result = (j - k - 1) * ar[currentIndex];
            max = Math.max(result, max);
        }
        return max;
    }
}
