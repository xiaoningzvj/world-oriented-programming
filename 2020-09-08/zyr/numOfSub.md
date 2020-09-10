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

