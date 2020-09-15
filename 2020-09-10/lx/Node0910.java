import javax.xml.soap.Node;

/**
 * @author liangxin
 * @classname
 * @description
 * @date 2020.09.11
 **/
public class Node0910<T extends Comparable> {
    private T value;

    public Node0910 next;

    public Node0910(T data) {
        this.value = data;
    }

    @Override
    public String toString() {
        return " " + value + next;
    }

    /**
     * # 删除链表的中间节点和a/b处的节点 :
     * 【题目】
     * 给定链表的头节点head,实现删除链表的中间节点的函数。
     * 例如:
     * 不删除任何节点:
     * 1->2,删除节点1
     * 1->2->3,删除节点2
     * 1>2->3->4,删除节点2
     * 1>2->3->4>5,删除节点3
     */
    public Node0910<T> deleteMidNode(Node0910 head) {
        if (head == null || head.next == null) return head;
        if (head.next.next == null) return head.next;
        Node0910 pre = head;
        Node0910 cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            //查找当前删除节点的前一个节点
            pre = pre.next;
            //查找奇数规则遍历原链表
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    /**
     * 进阶:
     *      给定链表的头节点head、整数a和b,实现删除位于a/b处节点的函数。例如:
     *      链表:1->2->3>4>5,假设a/b的值为r
     *      如果r等于0,不删除任何节点
     *      如果r在区间(0,1/5]上,删除节点1
     *      如果r在区间(1/5,2/5]上,删除节点2
     *      如果r在区间(2/5,3/5]上,删除节点3:
     *      如果r在区间(3/5,4/5]上,删除节点4
     *      如果r在区间(4/5,1]上,删除节点5;
     *      如果r大于1,不删除任何节点。
     * @param head
     * @param a
     * @param b
     * @return
     */
    public Node0910<T> deleteADivideBNode(Node0910 head, int a, int b) {
        //获取链表总长度
        Node0910 cur = head;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        //按规则查找要删除的节点的前一个节点
        double r = (double) a*n/b;
        double ceil = Math.ceil(r);
        if (ceil == 0) return head;
        int beforeDelete = (int)ceil - 1;
        if (beforeDelete == 0) return head.next;
        int count = 0;
        cur = head;
        while (cur != null) {
            count++;
            if (count == beforeDelete) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return head;
    }

    public Node0910 reverseList(Node0910 head) {

        return null;
    }
}
