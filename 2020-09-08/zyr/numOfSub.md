###  最大值减去最小值或小于等于num

【题目】
::: tip 题目描述
给定数组 arr 和整数 num，共返回有多少个子数组满足如下情况：
 max(arr[i...j]) - min(arr[i...j]) <= num
max(arr[i...j])表示子数组arr[i...j]中的最大值，min[arr[i...j])表示子数组arr[i...j]中的最小值。
:::

【思路】
:clown_face:

* 一开始采用的是循环遍历两遍的操作，不是最优解。时间复杂度n方

``` js
  const nums = readline().split(' ').map(Number);
  const num = nums[1],  n = nums[0];
  const arr = readline().split(' ').map(Number);
  let res = 0;
  // 一个最大值栈的集合
  // 一个最小值栈的集合
  // 一个活动窗口，负责展示数据
  let qmax, qmin;
  for(let i = 0; i<n;i++) {
          qmin = arr[i];
          qmax = arr[i];
          for(let j = i; j< n;j++) {
              qmax = Math.max(qmax, arr[j]);
              qmin = Math.min(qmin, arr[j]);
              if(qmax - qmin <= num) {
                  res++;
              } else {
                  break
              }
          }
      }
  print(res);
```

【最优解思路】

:first_quarter_moon:

* 套用求取滑动窗口下的最大的值来计算

  * 首先固定最前面的窗口左侧`i`，右侧边框`j`

  * 生成两个双端队列，`qmax` `qmin`,  存储的是最大值和最小值所在的位置。

  * 在`j`不断的向右递增的过程中，保证双端队列始终维持着动态窗口的最大值和最小值的更新结构。

    * 是怎么维持着更新结构的呢。
    * 首先qmax
      * qmax只有大的数据才可以把自己数据的坐标存储进去，可以说是一个递增的坐标。
      * 当存储的数据大于队列队尾元素的时候，队尾元素出队。一直到队尾元素大于当前元素或者是队列为空的时候。
    * qmin
      * 和qmax一致，不过是一直在存储最小值。

  * ```javascript
    const nums = readline().split(' ').map(Number);
    const num = nums[1],  n = nums[0];
    const arr = readline().split(' ').map(Number);
    // 一个最大值栈的集合
    // 一个最小值栈的集合
    // 一个活动窗口，负责展示数据
    let qmax = []; let qmin = [];
    let i = 0;let  j = 0;let res = 0;
    if(arr && arr.length) {
        while(i < n) {
            while(j < n) {
                while(qmin.length && arr[qmin[0]] >= arr[j]) {
                    qmin.shift();
                }
                qmin.unshift(j);
                while(qmax.length && arr[qmax[0]] <= arr[j]) {
                    // 队尾删除数据
                    qmax.shift();
                };
                // 队尾插入数据
                qmax.unshift(j);
                if(arr[qmax[qmax.length - 1]] - arr[qmin[qmin.length - 1]] > num) {
                    break;
                }
                j++;
            }
            if(qmin[qmin.length - 1] === i) {
                // 移除队头元素，因为位置已经发生了移动
                qmin.pop();
            }
            if(qmax[qmax.length - 1] === i) {
                qmax.pop();
            }
            res += j - i;
            i++;
        }
    }
    print(res);
    ```

    

    ```
    
    ```

    