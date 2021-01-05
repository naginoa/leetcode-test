class Solution {
    public int[] searchRange(int[] nums, int target) {
        int a[] = {-999,-999};
        a[1] = search(nums, target);
        if(a[1]==-1){
            a[0]=-1;
            return a;
        }
        for(int i=a[1];i>=0;i--){
            if(nums[i]!=nums[a[1]]){
                a[0]=i+1;
                return a;
            }
        }
        a[0] = 0;
        return a;
    }
    public int search(int[] nums, int target) {
        if(nums.length==0)return -1;
        if(nums.length==1){
            if(nums[0]==target)return 0;
            else return -1;
        }
        return bin(nums, target, 0, nums.length-1);
    }
    public int bin(int[] nums, int target, int start, int end){
        if(start==end-1){
            //先返回后边稳定表示先返回后者  [2,2]
            if(nums[end]==target)return end;
            else if(nums[start]==target)return start;
            else return -1;
        }
        int mid = (start+end)/2;
        if(target<nums[mid])return bin(nums, target, start, mid);
        else return bin(nums, target, mid, end);
    }
}