package com.example.demo;

/**
 * @author fanhongjiang
 * @version 1.0
 * @date 2020/9/24 9:00
 */
public class ReSortList {
    public static void main(String[] args) {
        System.out.print(123456);
    }

    //第一种算法 荷兰国旗算法 -快排精髓
    public Node reSortList(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node current = head;
        int i = 0;
        while (current != null) {
            i++;
            current = current.right;
        }
        Node[] arr = new Node[i];
        current = head;
        i = 0;
        while (current != null) {
            arr[i++] = current;
            current = current.right;
        }
        //sort
        sort(arr, pivot);
        int j = 0;
        for (j = 0; j < arr.length - 1; j++) {
            arr[j].right = arr[j + 1];
        }
        arr[j].right = null;
        return arr[0];
    }

    public void sort(Node[] arr, int pivot) {
        int left = -1;
        int right = arr.length;
        int cur = 0;
        while (cur != right) {
            if (arr[cur].value < pivot) {
                swap(arr, ++left, cur++);
            } else if (arr[cur].value == pivot) {
                cur++;
            } else {
                swap(arr, --right, cur);
            }
        }
    }

    public void swap(Node[] arr, int i, int j) {
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
