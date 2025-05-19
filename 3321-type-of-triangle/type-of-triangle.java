class Solution {
    public String triangleType(int[] nums) {
        if (nums.length != 3) {
            return "none";
        }

        int a = nums[0], b = nums[1], c = nums[2];

        // Optional: Triangle inequality check
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none"; // Not a valid triangle
        }

        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || b == c || a == c) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}
