package com.example.demo.day1.question1;

import java.util.Stack;

/**
 * @author liangxin
 * @classname
 * @description
 * @date 2020.08.30
 **/
public class TestQuestion1 {
    public static void main(String[] args) {

        GetStackMin<Integer> gmin = new GetStackMin<>();
        gmin.push(3);
        gmin.push(1);
        gmin.pop();
        gmin.push(5);

        Integer min = gmin.getMin();
        System.out.println(min);
        System.out.println(gmin.pop());
        System.out.println(gmin.pop());


        GetStackMin<String> gmin1 = new GetStackMin<>();
        gmin1.push("aa");
        gmin1.push("bb");
        gmin1.push("cc");
        System.out.println(gmin1.getMin());
    }
}
