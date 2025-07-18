class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // 1st : i will find max straight path sum 
        // 2nd : i will find min straight path sum 
        // 3rd : total sum 
        // will return max of max straight path sum  or (array sum - minstraight path sum )

        int n =nums.length;
        int max_str = Integer.MIN_VALUE;
        int min_str = Integer.MAX_VALUE ;
        int arr_sum = 0;

        int temp_maxSum=0;
        int temp_minSum =0;

        for(int i =0;i<n;i++){
            arr_sum+=nums[i];

            temp_maxSum+=nums[i];
             max_str = Math.max(max_str , temp_maxSum);
            // max_str = max_str < temp_maxSum ? temp_max :max_Str;
          if( temp_maxSum<0){
            temp_maxSum=0;
          }
            temp_minSum+=nums[i];
             min_str = Math.min(min_str , temp_minSum);
            // min_str = min_str < temp_maxSum ? temp_max :max_Str;
          if( temp_minSum>0){
            temp_minSum=0;
          }

        }

        if(arr_sum==min_str) 
        return max_str;

        return Math.max(max_str , arr_sum-min_str);
    }
}