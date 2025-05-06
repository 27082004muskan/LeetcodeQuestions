class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        for(int i =0;i<n;i++){
            temp[i]=nums[nums[i]];
        }
        return temp;
    }
}