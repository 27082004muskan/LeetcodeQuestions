class Solution {
    public int findPeakElement(int[] nums) {
    //     int left=0;
    //     int right=nums.length-1;
    //     while(left<right)
    // {
    //     int mid=left+(right-left)/2;
    //     if(nums[mid]<nums[mid+1])
    //     left=mid+1;
    //     else
    //     right=mid;
    // }
    // return left;


    int n = nums.length;
        if(n == 1 || nums[0] > nums[1]) {
        return 0;
    }
    
    // Check if last element is peak
    if(nums[n-1] > nums[n-2]) {
        return n-1;
    }
    for(int i =1;i<n-1;i++){
        if(nums[i-1]<nums[i] && nums[i]>nums[i+1]){
            return i ;
            
        }
    }
    return -1;
    }
}