class Solution {
    //必须去掉static不然会错误 把两个函数和变量的static都去掉
    static int num=0;
    public static int numIslands(char[][] grid) {
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1'){
                    dfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }
    public static void dfs(char[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;

        // i>m-1||j>n-1要放在前面 不然grid[i][j]会先array越界  烦的
        if (i<0||j<0||i>m-1||j>n-1||grid[i][j]=='0')return;

        grid[i][j] = '0';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}