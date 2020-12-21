class Solution {
    public int removeElement(int[] nums, int val) {
        int flag=0;
        int len=nums.length - 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val)flag++;
        }
        for(int i=0;i<flag;i++){
            if(nums[i]==val){
                while(nums[len]==val)len--;
                int t=nums[i];
                nums[i] = nums[len];
                nums[len] = t;
            }
        }
        return flag;
    }
}