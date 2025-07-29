// public class Solution {
//     public int[] intersection(int[] nums1, int[] nums2) {
//         Set<Integer> st1 = new HashSet<>();
//         Set<Integer> st2 = new HashSet<>();
        
//         for (int i = 0; i < nums1.length; i++) {
//             st1.add(nums1[i]);
//         }
        
//         for (int i = 0; i < nums2.length; i++) {
//             if (st1.contains(nums2[i])) {
//                 st2.add(nums2[i]);
//             }
//         }
        
//         int[] result = new int[st2.size()];
//         int i = 0;
//         for (Integer num : st2) {
//             result[i++] = num;
//         }
        
//         return result;
//     }
// }



//Approach-2 (Using one set)
//T.C : O(m+n)
//S.C : O(m+n)
// class Solution {
//     public int[] intersection(int[] nums1, int[] nums2) {
//         HashSet<Integer> set = new HashSet<>();
//         List<Integer> result = new ArrayList<>();

//         for (int num : nums1) {
//             set.add(num);
//         }

//         for (int num : nums2) {
//             if (set.contains(num)) {
//                 result.add(num);
//                 set.remove(num);
//             }
//         }

//         return result.stream().mapToInt(Integer::intValue).toArray();
//     }
// }


// APPROACH 3 -----------------------------

 class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int m = nums1.length;
        int n = nums2.length;

        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);


                 //if they are same
                while (i < m - 1 && nums1[i] == nums1[i + 1]) {
                    i++;
                }
                while (j < n - 1 && nums2[j] == nums2[j + 1]) {
                    j++;
                }
                i++;
                j++;

            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] ans = new int[result.size()];
for (int k = 0; k < result.size(); k++) {
    ans[k] = result.get(k);
}
return ans;

    }
}