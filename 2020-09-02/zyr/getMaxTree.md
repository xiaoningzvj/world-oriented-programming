# getMaxTree

题目描述

>给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
>
>二叉树的根是数组中的最大元素。
>左子树是通过数组中最大值左边部分构造出的最大二叉树。
>右子树是通过数组中最大值右边部分构造出的最大二叉树。
>通过给定的数组构建最大二叉树，并且输出这个树的根节点。

解题思路

* 递归

  * 一开始接触的时候认为是首先想到的是递归

    * 判断是递归之后

      * 递归的参数，每一次分割之后的节点数组
      * 是否是完全递归
      * 递归的临界条件

    * 找到最大值，进行切割

      ```javascript
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

      

