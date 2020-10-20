package com.es.demo.q;

import com.es.demo.q.baseStruce.IntersectDto;
import com.es.demo.q.baseStruce.Node;

/**
 * @author fanhongjiang
 * @version 1.0
 * @date 2020/10/19 9:31
 */
public class IntersectFirstPoint {

    //要求空间复杂度为1  时间复杂度为m+n
    public Node getIntesectFirstPoint(Node head1, Node head2) {
        //首先经过分析 排除 无环单链表和有环单链表 一定不想交
        //子问题1  如何判断一个单链表是否有环，并返回第一个入环节点
        //子问题2  如何判断 两个无环单链表是否相交，并返回相交节点
        //子问题3  如何判断 两个有环单链表是否相交，并返回相交节点
        if (head1 == null || head2 == null) {
            return null;
        }
        IntersectDto node1 = getCircleHead(head1);
        IntersectDto node2 = getCircleHead(head2);
        if ((node1.isCircle() && !node2.isCircle()) || (node2.isCircle() && !node1.isCircle())) {
            return null;
        } else if (!node1.isCircle() && !node2.isCircle()) {
            return getNoCirclePoint(head1, head2, null).getNode();
        } else {
            return getCirclePoint(head1, getCircleHead(head1).getNode(), head2, getCircleHead(head2).getNode()).getNode();
        }
    }

    private IntersectDto getCircleHead(Node head) {
        IntersectDto intersectDto = new IntersectDto();
        intersectDto.setCircle(false);
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null && fast.next != null) {
            if (fast == slow) {
                //证明为环
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                intersectDto.setCircle(true);
                intersectDto.setNode(fast);
                return intersectDto;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return intersectDto;
    }

    private IntersectDto getNoCirclePoint(Node head1, Node head2, Node tail) {
        IntersectDto intersectDto = new IntersectDto();
        int head1Length = 1;
        int head2Length = 1;
        Node end1 = head1;
        Node end2 = head2;

        while (end1.next != null) {
            if (end1 == tail) {
                break;
            }
            end1 = end1.next;
            head1Length++;
        }
        while (end2.next != null) {
            if (end2 == tail) {
                break;
            }
            end2 = end2.next;
            head2Length++;
        }
        if (end1 != end2) {
            return intersectDto;
        } else {
            //相交 找交点
            int min = Math.abs(head1Length - head2Length);
            if (head1Length >= head2Length) {
                while (min-- != 0) {
                    head1 = head1.next;
                }
            } else {
                while (min-- != 0) {
                    head2 = head2.next;
                }
            }
            while (head1 != head2) {
                head1 = head1.next;
                head2 = head2.next;
            }
            intersectDto.setNode(head1);
            return intersectDto;
        }
    }

    private IntersectDto getCirclePoint(Node head1, Node point1, Node head2, Node point2) {
        IntersectDto intersectDto = new IntersectDto();
        if (point1 == point2) {
            return getNoCirclePoint(head1, head2, point1);
        } else {
            Node cur = point1;
            while (cur.next != point1) {
                if (cur == point2) {
                    intersectDto.setNode(point1);
                    return intersectDto;
                }
                cur = cur.next;
            }
            return intersectDto;
        }
    }
}
