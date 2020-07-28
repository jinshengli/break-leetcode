

### 递归专题

#### 递归原则

    1. 拒绝人肉递归 
    2. 找重复子问题



#### 水题


1） 938. 二叉搜索树的范围和

https://leetcode-cn.com/problems/range-sum-of-bst/


2) 面试题 16.11. 跳水板

这题不用递归，超时了。
https://leetcode-cn.com/problems/diving-board-lcci/


3)  39. 组合总和
 
 https://leetcode-cn.com/problems/combination-sum/
 
 回溯； 注意去重，去掉重复的分支。



4) 40. 组合总和 II

https://leetcode-cn.com/problems/combination-sum-ii/

    需要剪枝；同层不应该出现相同的元素，不同层可以出现
    相同元素。



5) 77. 组合

https://leetcode-cn.com/problems/combinations/
 
 确定递归终止层数； 回溯； 
 
 确定当前层的范围，下一层的范围
 
 兄弟节点 的子树不应该有重。
 
 
 
 6) 226. 翻转二叉树

https://leetcode-cn.com/problems/invert-binary-tree/description/


7) 98. 验证二叉搜索树

https://leetcode-cn.com/problems/validate-binary-search-tree/

需要经常看这题，理解；

有两种方法：

    1. 中序遍历，每次都记录一下它的前驱节点的值和当前的值。
    2. 递归遍历，定义左子树的上界，定义右子树的下界。
    

8)  46. 全排列

https://leetcode-cn.com/problems/permutations/

    方便起见，添加一个visited标记数组。

9） 64. 最小路径和

https://leetcode-cn.com/problems/minimum-path-sum/



10） 47. 全排列 II

https://leetcode-cn.com/problems/permutations-ii/

    需要复习

11） 1219. 黄金矿工 

https://leetcode-cn.com/problems/path-with-maximum-gold/



12) 216. 组合总和 III


https://leetcode-cn.com/problems/combination-sum-iii/c


13) 687. 最长同值路径
    
    不好想。

https://leetcode-cn.com/problems/longest-univalue-path/



 
 