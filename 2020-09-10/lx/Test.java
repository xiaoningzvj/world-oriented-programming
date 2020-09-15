
/**
 * @author liangxin
 * @classname
 * @description
 * @date 2020.09.13
 **/
public class Test {
    public static void main(String[] args) {
//        double a = (double) 0/ 3;
//        int b = (int) a;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(a == 0);
        Node0910<Integer> head1 = new Node0910<>(1);
        Node0910<Integer> head11 = new Node0910(2);
        head1.next = head11;
        Node0910<Integer> head12 = new Node0910(3);
        head11.next = head12;
        Node0910<Integer> head13 = new Node0910(4);
        head12.next = head13;
        Node0910<Integer> head14 = new Node0910(5);
        head13.next = head14;
        Node0910<Integer> integerNode0910 = head1.deleteADivideBNode(head1, 3, 5);
        System.out.println(integerNode0910);
    }
}
