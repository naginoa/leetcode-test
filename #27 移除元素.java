class Solution {
    public int removeElement(int[] nums, int val) {
        int flag=0;
        int len=nums.length - 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                nums[i]=Integer.MIN_VALUE;
            }
            else flag++;
        }
        for(int i=0;i<flag;i++){
            if(nums[i]==Integer.MIN_VALUE){
                while(nums[len]==Integer.MIN_VALUE)len--;
                int t=nums[i];
                nums[i] = nums[len];
                nums[len] = t;
                //System.out.println(1111);
            }
        }
        return flag;
    }
}