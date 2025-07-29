public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> st1 = new HashSet<>();
        Set<Integer> st2 = new HashSet<>();
        
        for (int i = 0; i < nums1.length; i++) {
            st1.add(nums1[i]);
        }
        
        for (int i = 0; i < nums2.length; i++) {
            if (st1.contains(nums2[i])) {
                st2.add(nums2[i]);
            }
        }
        
        int[] result = new int[st2.size()];
        int i = 0;
        for (Integer num : st2) {
            result[i++] = num;
        }
        
        return result;
    }
}