# 用栈来实现汉诺塔问题

> 问题描述：
>
> 汉诺塔问题比较经典，这里修改一下游戏规则：现在限制不能从最左侧的塔直接移动到最右侧，也不能从最右侧直接移动到最左侧，而是必须经过中间。求当塔有n层的时候，打印最优移动过程和最优移动总步数。

* 递归算法

```javascript
let nums = parseInt(readline());
function hanoiProblem(num, left, mid, right){
    if(num < 1) {
        return 0
    }
    return process(num, left, right);
}
function process(num, from, to) {
    if(num === 1) {
        if(from === 'mid' || to === 'mid') {
            print(`Move 1 from ${from} to ${to}`);
            return 1;
            
        } else {
            print(`Move 1 from ${from} to mid`);
            print(`Move 1 from mid to ${to}`);
            return 2;
        }
    }
    if(from === 'mid' || to === 'mid') {
        const another = (from === 'left' || to === 'left' ) ? 'right' : 'left';
        const p1 = process(num - 1,from, another);
        const p2 = 1;
        print(`Move ${num} from mid to ${to}`);
        const p3 = process(num -1,another, to);
        return p1+p2+p3;
    } else {
        const p1 = process(num - 1, from, to);
        let p2 = 1;
        print(`Move ${num} from ${from} to mid`);
        const p3 = process(num - 1, to,from);
        p2++;
        print(`Move ${num} from mid to ${to}`);
        const p4 = process(num -1,from, to);
        return p1+p2+p3+p4;
    }
}
const step = hanoiProblem(nums,'left','mid','right');
print(`It will move ${step} steps.`)
```

