# leetcode做题笔记
## [221] 最大正方形

题目: https://leetcode-cn.com/problems/maximal-square/

![image](https://user-images.githubusercontent.com/28385060/119346630-0a2d7180-bccd-11eb-99c4-1450691cd6fc.png)

![image](https://user-images.githubusercontent.com/28385060/119347272-e1f24280-bccd-11eb-835d-2e1e25c03b1a.png)

一个值最大的条件就是这四块的内容都为1，假设这是第dis轮迭代，那么该dp[i][j]上的临近四个点的值都需要是dis的平方,那么该值等于(dis+1)的平方,否则等于原来的值

并且该值一定要存在原数组的左上角，这样在下次和下轮迭代中就不会出现重叠。

```
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        dp = [[0] * (len(matrix[0])+1) for i in range(len(matrix)+1)] 
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                dp[i][j] = 1 if matrix[i][j] == '1' else 0
        if len(matrix) == 1:
            return max(dp[0])
        if len(matrix[0]) == 1:
            return max(dp)[0]
        dis = 1
        res = 0
        while dis < len(matrix):
            for i in range(len(matrix)-1-(dis-1)):
                for j in range(len(matrix[0]) - (dis-1)):
                    if dp[i][j]==0 and dp[i+1][j]==0 and dp[i][j+1]==0 and dp[i+1][j+1]==0:
                        dp[i][j] = 0
                    else:
                        dp[i][j] = (dis+1) ** 2 if (dp[i][j] == dis**2 and dp[i+1][j]==dis**2 and dp[i][j+1]==dis**2 and dp[i+1][j+1]==dis**2) else (dp[i][j] if dis != 1 else 1)
                    res = max(max(max(max(res, dp[i][j]), dp[i][j+1]), dp[i+1][j]), dp[i+1][j+1])
            if res < dis**2:
                return res
            dis += 1
            
        return res
```

## [555] 携程春招笔试题6.10第一道题 类似力扣55
给定一个非负数组, nums = [1, 3, 4, 0, 6, 2, 2, 4, 5] 其中每个数字代表能往下走多少个位置. 如3即往后可以走3布，至此和力扣55完全一致。问题升级，不是判断是否能走到超过最后一位，而是统计有多少种方式。

起初思路是dp，即dp[i]表示 到数字i有n种通过方式。定义所有的dp数组初始化为0。测试未通过。原因即在此。dp[1]应该定义为1！！！

![image](https://user-images.githubusercontent.com/28385060/121553784-2dce1700-ca44-11eb-8e19-08eb9a49cb2b.png)

代码如下:

```
nums = [1, 3, 4, 0, 6, 2, 2, 4, 5]
# 默认到该点的初始方式都为1
dp = [0 for i in range(len(nums)+1)]
#dp[1] = 1这个初始化想不到
dp[1] = 1
for i in range(len(nums)):
    for j in range(1, nums[i]+1):
        if i+j < len(nums)+1:
            dp[i+j] += dp[i]
#print(dp)
print(dp[-1])
```

