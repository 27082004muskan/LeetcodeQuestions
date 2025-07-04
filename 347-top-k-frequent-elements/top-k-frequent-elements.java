class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        // Step 1: Create a frequency map
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert map entries to a list
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(hm.entrySet());

        // Step 3: Sort by frequency in descending order
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Step 4: Create result array and store top K elements
        int[] result = new int[k];  //  Declare this
        for (int i = 0; i < k; i++) {
            result[i] = entryList.get(i).getKey();
        }

        return result;
    }
}
