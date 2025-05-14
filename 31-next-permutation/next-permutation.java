
// class Solution {
//     public void nextPermutation(int[] nums) {
//         List<List<Integer>> permutations = new ArrayList<>();
//         Arrays.sort(nums);  // Sorting is important to handle duplicates
//         boolean[] used = new boolean[nums.length];

//         backtrack(permutations, new ArrayList<>(), nums, used);

//         // Convert current nums to a list
//         List<Integer> current = new ArrayList<>();
//         for (int num : nums) current.add(num);

//         // Find index of current permutation
//         int idx = 0;
//         for (int i = 0; i < permutations.size(); i++) {
//             if (permutations.get(i).equals(current)) {
//                 idx = i;
//                 break;
//             }
//         }

//         // Get next permutation or wrap to the first
//         List<Integer> next = (idx + 1 < permutations.size()) ? permutations.get(idx + 1) : permutations.get(0);

//         // Copy result back to nums[]
//         for (int i = 0; i < nums.length; i++) {
//             nums[i] = next.get(i);
//         }
//     }

//     private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used) {
//         if (temp.size() == nums.length) {
//             result.add(new ArrayList<>(temp));
//             return;
//         }

//         for (int i = 0; i < nums.length; i++) {
//             // Skip used elements
//             if (used[i]) continue;

//             // Skip duplicates
//             if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

//             used[i] = true;
//             temp.add(nums[i]);

//             backtrack(result, temp, nums, used);

//             used[i] = false;
//             temp.remove(temp.size() - 1);
//         }
//     }
// }

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;

        // Step 1: Find the first index from the end where nums[i] > nums[i-1]
        // This means nums[i-1] is the pivot (the number we need to swap to get a bigger permutation)
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--; // Move left
        }

        // Now i is the point where the suffix becomes strictly decreasing
        // So, nums[i-1] is the number we want to replace with the next bigger number on the right
        if (i != 0) {
            int index = i;

            // Step 2: From the end, find the number just bigger than nums[i-1]
            for (int j = n - 1; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {
                    index = j;
                    break;
                }
            }

            // Swap nums[i-1] with nums[index]
            // This increases the number just slightly to get the next permutation
            swap(nums, i - 1, index);
        }

        // Step 3: Reverse the subarray from i to the end
        // This is because the suffix is currently in descending order
        // Reversing it gives the smallest possible order (which is required after swapping)
        reverse(nums, i, n - 1);
    }

    // Swap helper function
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Reverse helper function
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}

