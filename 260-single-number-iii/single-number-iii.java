class Solution {
    public int[] singleNumber(int[] nums) {
        int txor=0;
        for(int i =0;i<nums.length;i++){
            txor^=nums[i];
        }
        int mask=(txor & (txor-1))^txor;
        int res[]= new int[2];
         for(int i =0;i<nums.length;i++){
            if((nums[i] & mask)==0){
                res[0]^=nums[i];
            }else{
                res[1]^=nums[i];
            }
        }
return res;
    }
}