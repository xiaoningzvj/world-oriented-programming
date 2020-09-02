package com.kning.demo;

/**
 * @author 王康宁
 * @version 1.0
 * @date 2020/9/2
 **/
public class Hanoi {
    public static final String MID = "mid";
    public static final String LEFT = "left";
    public static final String RIGHT = "right";

    public void recurrence(int n, String from, String to) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            if (MID.equals(from) || MID.equals(to)) {
                System.out.printf("move [%2d] %6s -> %6s\n", n, from, to);
            } else {
                System.out.printf("move [%2d] %6s -> %6s\n", n, from, MID);
                System.out.printf("move [%2d] %6s -> %6s\n", n, MID, to);
            }
            return;
        }
        if (LEFT.equals(from) && MID.equals(to)) {
            recurrence(n - 1, from, RIGHT);
            System.out.printf("move [%2d] %6s -> %6s\n", n, from, to);
            return;
        }
        if (LEFT.equals(from) && RIGHT.equals(to)) {
            recurrence(n - 1, LEFT, RIGHT);
            System.out.printf("move [%2d] %6s -> %6s\n", n, from, MID);
            recurrence(n - 1, RIGHT, LEFT);
            System.out.printf("move [%2d] %6s -> %6s\n", n, MID, to);
            recurrence(n - 1, LEFT, RIGHT);
            return;
        }
        if (MID.equals(from) && RIGHT.equals(to)) {
            recurrence(n - 1, MID, LEFT);
            System.out.printf("move [%2d] %6s -> %6s\n", n, from, to);
            recurrence(n - 1, LEFT, RIGHT);
            return;
        }
        if (RIGHT.equals(from) && MID.equals(to)) {
            recurrence(n - 1, from, LEFT);
            System.out.printf("move [%2d] %6s -> %6s\n", n, from, to);
            return;
        }
        if (RIGHT.equals(from) && LEFT.equals(to)) {
            recurrence(n - 1, RIGHT, LEFT);
            System.out.printf("move [%2d] %6s -> %6s\n", n, from, MID);
            recurrence(n - 1, LEFT, RIGHT);
            System.out.printf("move [%2d] %6s -> %6s\n", n, MID, to);
            recurrence(n - 1, RIGHT, LEFT);
            return;
        }
        if (MID.equals(from) && LEFT.equals(to)) {
            recurrence(n - 1, MID, RIGHT);
            System.out.printf("move [%2d] %6s -> %6s\n", n, from, to);
            recurrence(n - 1, RIGHT, LEFT);
            return;
        }
        return;
    }

    public static void main(String[] args) {
        new Hanoi().recurrence(3, LEFT, RIGHT);
    }
}
