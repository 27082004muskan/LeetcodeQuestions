// class Solution {
//     public List<Integer> countSmaller(int[] nums) {
//         int n = nums.length;
//         int count =0;
//           List<Integer> list = new ArrayList<>();
//         for(int i =0;i<n-1;i++){
//             for(int j = i+1;j<n;j++){
       
//        if(nums[i]>nums[j]){
//         count++;
        
//        }
//        list.add(count);
//        count =0;
//             }
             
//         }
      
//         return list ;
//     }
// }


class Solution {
    // Main function
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];          // Stores the counts
        int[] indices = new int[n];         // Stores the original indices

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        mergeSort(nums, indices, result, 0, n - 1);
        List<Integer> ans = new ArrayList<>();

        for (int count : result) {
            ans.add(count);
        }

        return ans;
    }

    private void mergeSort(int[] nums, int[] indices, int[] result, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(nums, indices, result, left, mid);
        mergeSort(nums, indices, result, mid + 1, right);
        merge(nums, indices, result, left, mid, right);
    }

    private void merge(int[] nums, int[] indices, int[] result, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;         // pointer for left subarray
        int j = mid + 1;      // pointer for right subarray
        int k = 0;            // pointer for temp array
        int rightCount = 0;   // number of right elements moved before left

        while (i <= mid && j <= right) {
            if (nums[indices[j]] < nums[indices[i]]) {
                temp[k++] = indices[j++];
                rightCount++;
            } else {
                result[indices[i]] += rightCount;
                temp[k++] = indices[i++];
            }
        }

        while (i <= mid) {
            result[indices[i]] += rightCount; // remaining left elements
            temp[k++] = indices[i++];
        }

        while (j <= right) {
            temp[k++] = indices[j++];
        }

        // Copy the sorted temp back to indices
        for (int p = 0; p < temp.length; p++) {
            indices[left + p] = temp[p];
        }
    }
}
