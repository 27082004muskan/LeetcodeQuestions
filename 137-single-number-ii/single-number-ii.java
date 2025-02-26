class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer , Integer> mp = new HashMap<>();

        for(int num:nums){
            mp.put(num , mp.getOrDefault(num, 0)+1);
        }
        for(Map.Entry<Integer , Integer> entry:mp.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;
    }
}