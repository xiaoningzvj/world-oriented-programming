/**
 * @author liangxin
 * @classname
 * @description
 * @date 2020.09.11
 **/
public class TwoWayNode<T extends Comparable> {

    public TwoWayNode<T> last;
    public T value;
    public TwoWayNode<T> next;

    public TwoWayNode(T value) {
        this.value = value;
        this.last = null;
        this.next = null;
    }


    public TwoWayNode deleteReciprocalKNode(TwoWayNode node,int k) {
        int n = 0;
        T h;
        if (node == null || k < 1) return null;
        TwoWayNode inside = node;
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
            inside.next.last = inside;
        }
        return node;
    }


    @Override
    public String toString() {
        return " " + value + next;
    }
}
