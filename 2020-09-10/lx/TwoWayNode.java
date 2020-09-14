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

    @Override
    public String toString() {
        return " " + value + next;
    }
}
