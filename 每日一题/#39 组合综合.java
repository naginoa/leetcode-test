class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> row = new LinkedList<>();
        dfs(target, row, 0, candidates, res);
        return res;
    }
    public static void dfs(int target, List<Integer> row, int index, int[] candidates, List<List<Integer>> res){
        if(index>=candidates.length)return;
        if(target==0){
            res.add(new LinkedList(row));
            return;
        }
        if(target<0)return;

        dfs(target, row, index+1, candidates, res);
        row.add(candidates[index]);
        dfs(target-candidates[index], row, index, candidates, res);
        row.remove(row.size()-1);
    }
}