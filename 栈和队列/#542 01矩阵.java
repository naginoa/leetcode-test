class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (m==0)return matrix;
        int[][] result = matrix;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = BFSdistance(matrix, i, j);
            }
        }
        return result;
    }
    public int BFSdistance(int[][] matrix, int i, int j){
        int m = matrix.length, n = matrix[0].length;
        if (i<0||j<0||i>=m||j>=n)return Integer.MAX_VALUE;
        if (matrix[i][j]==0)return 0;
        int result = 0;
        Deque<Integer> raw = new LinkedList<>();
        Deque<Integer> col = new LinkedList<>();
        raw.addLast(i);
        col.addLast(j);
        while (!raw.isEmpty()){
            int len = raw.size();
            for (int i1 = 0; i1 < len; i1++) {
                int ti = raw.removeFirst();
                int tj = col.removeFirst();
                if (ti<0||tj<0||ti>=m||tj>=n)continue;
                int tmp = matrix[ti][tj];
                if (tmp==0)return result;
                raw.addLast(ti+1);
                raw.addLast(ti-1);
                raw.addLast(ti);
                raw.addLast(ti);
                col.addLast(tj);
                col.addLast(tj);
                col.addLast(tj-1);
                col.addLast(tj+1);
            }
            result += 1;
        }
        return result;
    }
}