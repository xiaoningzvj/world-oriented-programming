

# getMaxTree

### 题目

> 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
>
> 二叉树的根是数组中的最大元素。
> 左子树是通过数组中最大值左边部分构造出的最大二叉树。
> 右子树是通过数组中最大值右边部分构造出的最大二叉树。
> 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
>
> 难点： 要求时间复杂度是O(N),额外空间复杂度是O(N)

### 思路

> 一开始的思路是采取递归的方式

* 递归

  * 判断递归的情况
  * 递归的边界
  * 递归的完全性

* ```javascript
  /**
   * Definition for a binary tree node.
   * function TreeNode(val) {
   *     this.val = val;
   *     this.left = this.right = null;
   * }
   */
  /**
   * @param {number[]} nums
   * @return {TreeNode}
   */
  const constructMaximumBinaryTree = function(nums) {
      if(!nums.length)  return null
      const max = Math.max(...nums);
      const root = new TreeNode(max);
      const index = nums.indexOf(max);
      root.left = constructMaximumBinaryTree(nums.slice(0, index));
      root.right = constructMaximumBinaryTree(nums.slice(index + 1))
      return root;
  };
  ```

  这一种方式时间复杂度和空间复杂度都不符合规范。

  在于nums.slice()的方式，增加了时间复杂度。

### 最优解方式

* 根据题目要求的时间复杂度来看，遍历优于递归。

* 其就是指遍历，然后找每一个书左右两边第一个比他大的数。===》利用栈

  * 左边第一个比他大的，从左到右遍历每一个数，栈中保持递减的序列，栈顶元素不停的pop，直到栈顶元素比新的数据大或者栈空了。

  * 利用同样的方法可以求出每一个数往右边第一个比他大的数。

  * ```javascript
    var constructMaximumBinaryTree = function(nums) {
      // 采用栈的方式求解
        let stack = [];
        let currentNode = new TreeNode(null);
        for(let i = 0; i<nums.length;i++) {
            currentNode = new TreeNode(nums[i]);
            while(stack.length && stack[stack.length - 1].val < nums[i]) {
                const top = stack.pop();
                if(stack.length && stack[stack.length - 1].val < nums[i]) {
                    stack[stack.length - 1].right = top;
                } else {
                    currentNode.left = top; 
                }
            }
            stack.push(currentNode);
        }
        while(stack.length) {
            currentNode = stack.pop();
            if(stack.length) stack[stack.length - 1].right = currentNode;
        }
        return currentNode;
    };
    ```

    