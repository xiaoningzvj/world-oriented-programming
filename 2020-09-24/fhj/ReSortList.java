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

    //第二种做法  多链表法
    //搞三个链表  分小于 等于 大于 三个部分 分别去连
    //最后统一连接
    public Node reSortListTwo(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node lh = null;
        Node lt = null;
        Node mh = null;
        Node mt = null;
        Node rh = null;
        Node rt = null;
        Node next = null;
        while (head != null) {
            //提前获取下一节点
            next = head.right;
            //断开当前节点与后面的联系
            head.right = null;
            if (head.value < pivot) {
                if (lh == null) {
                    lh = head;
                    lt = head;
                } else {
                    lt.right = head;
                    lt = head;
                }
            } else if (head.value == pivot) {
                if (mh == null) {
                    mh = head;
                    mt = head;
                } else {
                    mt.right = head;
                    mt = head;
                }
            } else {
                if (rh == null) {
                    rh = head;
                    rt = head;
                } else {
                    rt.right = head;
                    rt = head;
                }
            }
            //遍历
            head = next;
        }
        //遍历结束 (ON) 做连接
        Node top = null;
        if (lh != null) {
            lh = top;
            if (mh != null) {
                lt.right = mh;
                mt.right = rh;
            } else {
                lt.right = rh;
            }
        } else {
            if (mh != null) {
                top = mh;
                mt.right = rh;
            } else {
                top = rh;
            }
        }
        return top;
    }
}
