/**
 * @author liangxin
 * @classname
 * @description
 * @date 2020.09.11
 **/
public class TwoWayNode0910<T extends Comparable> {

    public TwoWayNode0910<T> last;
    public T value;
    public TwoWayNode0910<T> next;

    public TwoWayNode0910(T value) {
        this.value = value;
        this.last = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return " " + value + next;
    }

    public Node0910 reverseList(Node0910 head) {
        return null;
    }

}
