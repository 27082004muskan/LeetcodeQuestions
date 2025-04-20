class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
       int n = nums.length;
       int temp[] = new int[n];
       for(int i =0;i<n;i++){
        for(int j =0;j<n;j++){
            if(j!=i && nums[j]<nums[i]){
                temp[i]++;
            }
        }
       } 
       return temp ;
    }
}