package com.example.demo.day3;

import java.util.Arrays;

/**
 * @author liangxin
 * @classname
 * @description 生成窗口最大数组
 * @date 2020.09.02
 **/
public class GetWindowMaxArray {

    public int[] getWindowMaxArray(int[] input,int windowSize) {
        int resultSize = input.length-windowSize+1;
        int[] result = new int[resultSize];
        int[] window = new int[windowSize];
        int resultNum = 0;
        for (int i = 0; i < resultSize; i++) {
            window = Arrays.copyOfRange(input,i,windowSize + i);
            int maxNum = getArrayMaxNum(window);
            result[resultNum] = maxNum;
            resultNum++;
        }
        return result;
    }

    private int getArrayMaxNum(int[] window) {
        Integer max = null;
        for (int i : window) {
            if (max == null) {
                max = i;
            }else {
                max = i > max ? i : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[]{4,3,5,4,3,3,6,7};
        GetWindowMaxArray getWindowMaxArray = new GetWindowMaxArray();
        int[] windowMaxArray = getWindowMaxArray.getWindowMaxArray(input, 3);
        for (int i : windowMaxArray) {
            System.out.print(i+",");
        }
    }

}
