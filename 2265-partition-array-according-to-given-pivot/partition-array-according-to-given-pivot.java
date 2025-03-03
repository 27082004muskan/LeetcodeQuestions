class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int lcount = 0, pcount = 0, Gcount = 0;
        
        // Step 1: Count elements
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) lcount++;
            else if (nums[i] > pivot) Gcount++;
            else pcount++;
        }
        
        int[] res = new int[nums.length];
        int i = 0, j = lcount, k = lcount + pcount;
        
        // Step 2: Fill result array
        for (int x = 0; x < nums.length; x++) {
            if (nums[x] < pivot) {
                res[i] = nums[x];
                i++;
            } else if (nums[x] == pivot) {
                res[j] = nums[x];
                j++;
            } else {
                res[k] = nums[x];
                k++;
            }
        }
        return res;
    }
}
