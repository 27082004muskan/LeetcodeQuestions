class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;

        long max = Long.MIN_VALUE;
        long secmax = Long.MIN_VALUE;
        long thirdmax = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] == max || nums[i] == secmax || nums[i] == thirdmax) continue;

            if (nums[i] > max) {
                thirdmax = secmax;
                secmax = max;
                max = nums[i];
            } else if (nums[i] > secmax) {
                thirdmax = secmax;
                secmax = nums[i];
            } else if (nums[i] > thirdmax) {
                thirdmax = nums[i];
            }
        }

        return thirdmax == Long.MIN_VALUE ? (int) max : (int) thirdmax;
    }
}
