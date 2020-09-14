/**
 * @author liangxin
 * @classname
 * @description
 * @date 2020.0909
 **/
public class PrintOrderList {
//    public static void main(String[] args) {
////        Node<Integer> head1 = new Node<>(2);
////        Node<Integer> head11 = new Node(3);
////        head1.next = head11;
////        Node<Integer> head12 = new Node(4);
////        head11.next = head12;
////        Node<Integer> head13 = new Node(7);
////        head12.next = head13;
////        Node<Integer> head14 = new Node(9);
////        head13.next = head14;
////        Node<Integer> head15 = new Node(13);
////        head14.next = head15;
////
////
////
////        Node<Integer> head2 = new Node<>(1);
////        Node<Integer> head21 = new Node(4);
////        head2.next = head21;
////        Node<Integer> head22 = new Node(6);
////        head21.next = head22;
////        Node<Integer> head23 = new Node(7);
////        head22.next = head23;
////        Node<Integer> head24 = new Node(10);
////        head23.next = head24;
////        Node<Integer> head25 = new Node(3);
////        head24.next = head25;
////
//////        head1.prinCommonPart(head1,head2);
////        System.out.println(head1);
////        head1.deleteReciprocalKNode(head1,2);
////        System.out.println(head1);
//
//    }


    public static void main(String[] args) {
        TwoWayNode<Integer> head1 = new TwoWayNode<>(2);
        TwoWayNode<Integer> head11 = new TwoWayNode(3);
        head1.next = head11;
        head11.last = head1;
        TwoWayNode<Integer> head12 = new TwoWayNode(4);
        head11.next = head12;
        head12.last = head11;
        TwoWayNode<Integer> head13 = new TwoWayNode(7);
        head12.next = head13;
        head13.last = head12;
        TwoWayNode<Integer> head14 = new TwoWayNode(9);
        head13.next = head14;
        head14.last = head13;
        TwoWayNode<Integer> head15 = new TwoWayNode(13);
        head14.next = head15;
        head15.last = head14;
        System.out.println(head1);

        TwoWayNode twoWayNode = head1.deleteReciprocalKNode(head1, 2);
        System.out.println(twoWayNode);
    }
}
