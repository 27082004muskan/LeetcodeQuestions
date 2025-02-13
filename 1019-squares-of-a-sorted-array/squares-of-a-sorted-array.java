class Solution {

    public int[] sortedSquares(int[] nums) {

        // for(int i=0;i<nums.length;i++){
        //   nums[i]*=nums[i];
        // }
        // Arrays.sort(nums);
        // return nums;
        int left=0;
        int n=nums.length;
        int right =n-1;
        int b[]=new int[n];
        int pos=n-1;

        while(left<=right){
            if(nums[left]*nums[left]>nums[right]*nums[right]){
                b[pos]=nums[left]*nums[left];
                left++;
            }else{
            b[pos]=nums[right]*nums[right];
            right--;
            }
            pos--;
        }
     return b;
    }
}