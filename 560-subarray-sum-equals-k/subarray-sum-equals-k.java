class Solution {
    public int subarraySum(int[] nums, int k) {
     int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> sumFreqMap = new HashMap<>();
        sumFreqMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum - k;
            count+=sumFreqMap.getOrDefault(rem,0);
            sumFreqMap.put(sum,sumFreqMap.getOrDefault(sum,0)+1);
        }
        return count;  
    }
}