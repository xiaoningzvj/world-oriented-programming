package com.example.demo;

import java.util.LinkedList;

/**
 * @author fanhongjiang
 * @version 1.0
 * @date 2020/9/2 8:57
 */
public class GetMaxArray {

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        GetMaxArray getMaxArray = new GetMaxArray();
        int[] res = getMaxArray.getMaxArray(8, 3, arr);
        for (int k : res) {
            System.out.print(k + " ");
        }
    }
    //惭愧 思路是看的，不过编码是自己写的
    public int[] getMaxArray(int n, int w, int[] arr) {
        int index = 0;
        int[] result = new int[n - w + 1];
        if (arr.length <= w) {
            return null;
        }
        LinkedList<Integer> queue = new LinkedList();
        for (int i = 0; i < arr.length; i++) {
            if (queue.isEmpty()) {
                queue.add(i);
            } else {
                while (!queue.isEmpty() && arr[queue.getLast()] != arr[i]) {
                    if (arr[queue.getLast()] >= arr[i]) {
                        queue.add(i);
                    } else {
                        queue.poll();
                    }
                }
                if (queue.isEmpty()) {
                    queue.add(i);
                }
                if (i < 2) {
                    continue;
                } else {
                    if (queue.getFirst() <= i - w) {
                        queue.poll();
                    }
                    result[index++] = arr[queue.getFirst()];
                }
            }
        }
        return result;
    }

}
