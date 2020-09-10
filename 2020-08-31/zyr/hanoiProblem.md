# 用栈来实现汉诺塔问题

> 问题描述：
>
> 汉诺塔问题比较经典，这里修改一下游戏规则：现在限制不能从最左侧的塔直接移动到最右侧，也不能从最右侧直接移动到最左侧，而是必须经过中间。求当塔有n层的时候，打印最优移动过程和最优移动总步数。

* 递归算法
  * 移动的过程中一直保持N在最下面，所以先固定N。N从left移动到mid，移动到right。
  * 需要经过一下一个步骤
  * N个层级的元素，从left-->right，一共有5部。
    1. 1~N-1，left--> right
       1. 递归运算。
    2. N left --> mid
    3. 1~N-1 right-->left
       1. 递归运算
    4. N mid-->right
    5. 1~N-1 left-->right
       1. 递归运算
  * 当从中间到两边时的情况，这属于发散的思维。题目不用这种条件也可以写出来，但是便准答案考虑的情况有很多种。
    * 每一次移动是基于mid
    * 1~N-1，从left-->mid,right-->mid,mid->left,mid->right
      * 这个步骤分成3部
        1. 1~N-2,left-->right
        2. N-1 left->mid
        3. 1~N -2 right -->mid
    * 把每一出现的情况都汇总放入都process 中，作为移动的处理递归函数。

```javascript
let num = parseInt(readline());
function hannoiProblem(num, left,mid,right) {
    if(num < 1) return 0;
    return process(num,left,mid,right,left,right);
}
function process(num,left,mid,right,from,to) {
    if(num === 1) {
        if(from === mid || right === mid) {
            print(`Move 1 from ${from} to ${to}`);
            return 1; 
        } else {
            print(`Move 1 from ${from} to mid`);
            print(`Move 1 from mid to ${to}`);
            return 2; 
        }
    }
    if(from === mid || to === mid) {
        const another = (from === left || to === left) ? 'right' : 'left';
        const p1 = process(num - 1,left, mid, right, from, another);
        const p2 = 1;
        print(`Move ${num} from ${from} to ${to}`);
        const p3 = process(num - 1,left,mid, right,another,to);
        return p1+p2+p3; 
    } else {
        const p1 = process(num - 1,left, mid, right, from, to);
        let p2 = 1;
        print(`Move ${num} from ${from} to mid`);
        const p3 = process(num - 1,left, mid, right, to, from);
        p2++;
        print(`Move ${num} from mid to ${to}`);
        const p4 = process(num-1,left,mid, right,from,to);
        return p1+p2+p3+p4; 
    }
}
const step = hannoiProblem(num, 'left','mid','right');
print(`It will move ${step} steps.`);
```

* 栈实现
  * 