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
