package com.es.demo.q.baseStruce;

import lombok.Data;

/**
 * @author fanhongjiang
 * @version 1.0
 * @date 2020/10/19 9:33
 */
public class Node<T> {
    public Node next;
    public Node pre;
    public T value;

    public Node() {

    }
}
