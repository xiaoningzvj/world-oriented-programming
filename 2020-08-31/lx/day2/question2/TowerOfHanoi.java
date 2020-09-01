package com.example.demo.day2.question2;

/**
 * @author liangxin
 * @classname
 * @description
 *
 * 汉诺塔问题比较经典，这里修改一下游戏规则，现在限制不能从最左侧的塔直接移动到最右侧，
 * 也不能从最右侧直接移动到最左侧，而是必须经过中间，求当塔有N层的时候，打印最优移动过程
 * 和最优移动总步数。
 *
 * @date 2020.09.01
 **/
public class TowerOfHanoi {

    public void getStep(int n) {
        int left = n;
        int mid = 0;
        int right = 0;
        int total = 0;
        printStep(left,mid,right,total);
    }

    private void printStep(int left, int mid, int right, int total) {
        if (left == 0) return;
        left --;


    }
}
