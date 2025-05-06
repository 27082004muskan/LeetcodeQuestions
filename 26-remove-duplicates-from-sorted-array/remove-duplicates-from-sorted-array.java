class Solution {
    public int removeDuplicates(int[] nums) {
        int n =nums.length;
    // int j=0;
    // for(int i=0;i<nums.length;i++){
    //     if(nums[j]!=nums[i]){
    //         j++;
    //         nums[j]=nums[i];
    //     }
    // }
    // return j=j+1;

 TreeMap<Integer, Integer> map = new TreeMap<>();

       
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Replace nums with unique keys from the map
        int i = 0;
        for (int key : map.keySet()) {
            nums[i++] = key;
        }

        return i; // new length of unique elements
    }

}
