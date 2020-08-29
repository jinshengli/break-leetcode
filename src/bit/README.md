#### 位运算



异或： 相同为0，不同为1。也可以用“不进位加法”理解

x^0 = x
x^1S = ~x // 1S = ~0
x^(~x) = 1s
x^x = 0
c = a^b => a^c = b, b^c = a // 交换两个数

a^b^c=a^(b^c)=(a^b)^c


###### 实战位运算要点

    1. 判断奇偶
    
    x%2 == 1 ===> (x&1) == 1
    x%2 == 0 ===> (x&1) == 0
    
    
    x>>1 ----> x / 2
    
    x = x/2; ----> x = x>>1;
    
    mid=(left+right)/2 ------> mid=(left+right)>>1;
    
    
    x=x&(x-1)清零最低位的1
    
    
    x&-x ==> 得到最低位的1
    
    -4:  在计算机中是用补码来保存的
    
    原码：10000000 00000000 00000000 00000100（转二进制，最高位为符号位）  
    反码：11111111 11111111 11111111 11111011（符号位不变，其余取反）  
    补码：11111111 11111111 11111111 11111100（反码+1）
        
         11111111 11111111 11111111 00000100  4的补码；原码      
    
    
    0 0010



    x&~x ==> 0






#### 题目

在 Java 中，编译器使用二进制补码记法来表示有符号整数。


191. 位1的个数

https://leetcode-cn.com/problems/number-of-1-bits/

注意：去坑； 
1. 常规查看每一二进制位；
2. 每次清除最后一位1.


231. 2的幂

https://leetcode-cn.com/problems/power-of-two/ 

判断它是否是 2 的幂次方。

n > 0 && 有且只有1位 1


190. 颠倒二进制位

https://leetcode-cn.com/problems/reverse-bits/

遍历每一位； 32位


136. 只出现一次的数字

https://leetcode-cn.com/problems/single-number/

原理：x ^ x ^ b = b


137. 只出现一次的数字 II

只有一个元素出现一次，其余出现了三次。
https://leetcode-cn.com/problems/single-number-ii/


面试题 17.01. 不用加号的加法

https://leetcode-cn.com/problems/add-without-plus-lcci/



面试题 16.01. 交换数字

https://leetcode-cn.com/problems/swap-numbers-lcci/




