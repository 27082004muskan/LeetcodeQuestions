class Solution {
    public int subsetXORSum(int[] nums) {
       return  findXORTotal(nums,0,0);
    }
    public int findXORTotal(int[] nums , int index , int xor){
        //base case 
        if(index==nums.length) return xor;
        int pick = findXORTotal(nums , index+1, xor^nums[index]);
        int nopick = findXORTotal(nums , index+1,xor);
        return pick+nopick;
    }

}