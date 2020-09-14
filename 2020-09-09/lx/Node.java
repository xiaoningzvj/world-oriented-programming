/**
 * @author liangxin
 * @classname
 * @description
 * @date 2020.09.11
 **/
public class Node<T extends Comparable> {
    private T value;

    public Node next;

    public Node(T data) {
        this.value = data;
    }

    public void prinCommonPart(Node head1,Node head2) {
        if (head1 == null || head2 == null) return;
        //将链表排序，指定该链表为升序

        //打印两个升序链表的共同部分
        while (head1!= null && head2 != null) {
            if (head1.value.compareTo(head2.value) == 0) {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }else if (head1.value.compareTo(head2.value) > 0) {
                head2 = head2.next;
            }else {
                head1 = head1.next;
            }
        }
    }

    public Node<T> deleteReciprocalKNode(Node node,int k) {
        int n = 0;
        T h;
        if (node == null || k < 1) return null;
        Node inside = node;
        while (inside != null) {
            n++;
            inside = inside.next;
        }
        if (n < k) return null;
        else if (n == k) node = node.next;
        else {
            int z = 1;
            inside = node;
            while (z < n-k) {
                z++;
                inside = inside.next;
            }
            inside.next = inside.next.next;
        }
        return node;
    }

    @Override
    public String toString() {
        return " " + value + next;
    }
}
