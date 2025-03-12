class Solution {
    public int maximumCount(int[] nums) {
        int n =nums.length;
        int pcount=0;
        int ncount=0;
        int MaxCount=Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            if(nums[i]>0) pcount++;
            if(nums[i]<0) ncount++;
        }
        return Math.max(pcount , ncount);
    }
}