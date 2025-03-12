// class Solution {
//     public int maximumCount(int[] nums) {
//         int n =nums.length;
        // int pcount=0;
        // int ncount=0;
        // int MaxCount=Integer.MIN_VALUE;
        // for(int i =0;i<n;i++){
        //     if(nums[i]>0) pcount++;
        //     if(nums[i]<0) ncount++;
        // }
        // return Math.max(pcount , ncount);


        // Map<Integer , Integer> map = new HashMap<>();
        // map.put(1,0);
        // map.put(-1,0);
        // for(int num:nums){
        //     if(num >0 )  map.put(1,map.get(1)+1);
        //      if(num <0 )  map.put(-1,map.get(-1)+1);
        // }
        // return Math.max(map.get(1), map.get(-1));
// }

      



class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;

        // Binary search for the first positive number
        int firstPositiveIndex = findFirstPositive(nums);

        // Binary search for the first zero (or first positive)
        int firstNonNegativeIndex = findFirstNonNegative(nums);

        // Negative count = Elements before the first zero (or positive)
        int negativeCount = firstNonNegativeIndex;

        // Positive count = Elements from the first positive onwards
        int positiveCount = n - firstPositiveIndex;

        // Return maximum count
        return Math.max(negativeCount, positiveCount);
    }

    // Binary search to find the first positive element
    private int findFirstPositive(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) {
                right = mid - 1;  // Search on the left side
            } else {
                left = mid + 1;   // Search on the right side
            }
        }
        return left; // First positive element's index
    }

    // Binary search to find the first zero or positive element
    private int findFirstNonNegative(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= 0) {
                right = mid - 1;  // Search on the left side
            } else {
                left = mid + 1;   // Search on the right side
            }
        }
        return left; // First non-negative element's index
    }

  
}

    
