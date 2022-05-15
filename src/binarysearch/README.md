
#### 二分查找摸版


    int bsearch_1(int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
        


    int bsearch_2(int l, int r) {
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        return l;
    }

   特点都是 
        搜索区间： 左右闭合。  条件 left <= right 
        结束搜索条件： left = right + 1 ;   right > left  
        
            
       1) 如果是求最左区间；找到目标数时，先别返回值，搜索区间往左边靠近；
                     mid = right - 1;
          结束搜索：
                right, left
                
                target不存在：
                   1：left == nums.length
                   2：nums[left] != target
                
                否者
                    return left
       
       2) 如果求的是最右区间；找到目标数时，往右边的搜索区间逼近
                mid = left + 1
          
          同上：
                
                right < 0 || nums[right] != target 
                    return -1;
                
                return right 
                              
   
   



    // 一、寻找一个数（基本的二分搜索）
    public int search(int[] nums, int target) {
    
        int left = 0, right = nums.length-1;
        while ( left <= right ) {
            int mid = (left+right)/2;
            if ( nums[mid] < target ) {
                left = mid + 1;
            } else if ( nums[mid] > target ) {
                right = mid -1;
            } else {
                return mid;
            }
        }
        return -1;
    
    }


    // 查找目标数 第一次出现的下标
    int left_bound(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while ( left <= right ) {
            int mid = left + (right-left)/2;
            if ( nums[mid] < target ) {
                left = mid + 1;
            } else if ( nums[mid] > target ) {
                right = mid - 1;
            } else if ( nums[mid] == target ) {
                right = mid - 1; // 向左区间逼近
            }

        }

        if ( left >= nums.length || nums[left] != target ) // 判断目标数大于所有的元素；越界；元素不存在
            return -1;
        return left;
    }
    
    
    // 找到目标数的； 在最右的下标
        int right_bound(int[] nums, int target) {
    
            if ( nums == null || nums.length == 0 )
                return -1;
    
            int left = 0, right = nums.length -1;
    
            while ( left <= right ) {
    
                int mid = left + (right-left)/2;
                if ( nums[mid] < target ) {
                    left = mid + 1;
                } else  if ( nums[mid] > target ) {
                    right = mid - 1;
                } else if ( nums[mid] == target ) {
                    left = mid + 1;  // 向右区间逼近、
                }
            }
    
            if ( right < 0 || nums[right] != target )
                return -1;
            return right;
     }
        
        



 剑指 Offer 53 - I. 在排序数组中查找数字 I


https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/


392. 判断子序列

https://leetcode-cn.com/problems/is-subsequence/



69. x 的平方根

https://leetcode-cn.com/problems/sqrtx/


34. 在排序数组中查找元素的第一个和最后一个位置
https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/


