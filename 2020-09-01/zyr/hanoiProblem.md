#  生成窗口最大数组

【题目】

	> 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置，求每一种窗口状态下的最大值。（如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值）

* 思路

  * 一开始的思路

    * 是使用简单那的循环的方式，但是，最后会突破参数和数组解析的极限。造成数组的越界访问。

    * ```javascript
      const width = readline().split(' ').map(item=>parseInt(item))[1];
      const arr = readline().split(' ').map(item=>parseInt(item));
      let res = [];
      let start = 0;
      let end = width - 1;
      while(end !== arr.length) {
          const splitarr = arr.slice(start,end + 1);
          res.push(Math.max.apply(null, splitarr));
          start++;
          end++;
      } 
      print(res.join(' '));
      ```

      

  * 标准答案的思路

    * 双端队列， 存放arr的数组下标。实现窗口最大值的更新。

      * 双端队列就是两端都可以进行进栈和出栈的操作
      * 如果采用正常的思路来的话，时间复杂度O（N*w）

      ```javascript
      const w = readline().split(' ').map(item=>parseInt(item))[1];
      const arr = readline().split(' ').map(item=>parseInt(item));
      let res = [];
      let help = [];
      
      for(let i = 0; i < arr.length; i++) {
         while(help.length && arr[help[help.length - 1]] <= arr[i]) {
             help.pop();
         }
         help.push(i);
          if(help[0] === i - w) {
              help.shift();
          }
          if(i >= w - 1) {
              res.push(arr[help[0]]);
          }
      }
      console.log(res.join(' '));
      ```

      
