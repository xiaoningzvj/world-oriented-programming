package day4;

import java.util.Arrays;

/**
 * @author liangxin
 * @classname
 * @description
 * @date 2020.09.03
 **/
public class GetMaxTree {
    public static Node buildMacTree(int[] input) {
        int maxSubScript = getMaxSubScript(input);
        Node node = new Node(input[maxSubScript]);
        //按下标截取数据
        if (maxSubScript > 0) {
            int[] leftArray = Arrays.copyOfRange(input, 0, maxSubScript);
            Node leftNode = buildMacTree(leftArray);
            node.left = leftNode;
        }
        if (maxSubScript < input.length-1) {
            int[] rightArray = Arrays.copyOfRange(input, maxSubScript + 1, input.length);
            Node rightNode = buildMacTree(rightArray);
            node.right = rightNode;
        }
        return node;
    }

    private static int getMaxSubScript(int[] input) {
        int maxSubScript = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > input[maxSubScript]) maxSubScript = i;

        }
        return maxSubScript;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0,1,2,3,4,5};
        int[] input2 = new int[]{5,4,3,2,1,0};
        int[] input3 = new int[]{5,3,2,4,1,0};
        Node node = buildMacTree(input3);
        System.out.println(node);
    }

}
