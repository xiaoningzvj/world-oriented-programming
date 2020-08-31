package com.example.demo.day1.question2;

/**
 * @author liangxin
 * @classname
 * @description
 * @date 2020.08.30
 **/
public class TestQuestion2 {

    public static void main(String[] args) {
        ImitateTheQueue<Integer> queue = new ImitateTheQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println("--");
        System.out.println(queue.peek());
        System.out.println(queue.poll());

        System.out.println("--");
        System.out.println(queue.peek());
        System.out.println(queue.poll());

        System.out.println("--");
        System.out.println(queue.peek());
        System.out.println(queue.poll());

        System.out.println("--");
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }
}
