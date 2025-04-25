class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
       int n = arr.length;
       int min=Integer.MAX_VALUE; 
       List<List<Integer>> ans = new ArrayList<>();
      
        Arrays.sort(arr);
       for(int i =1;i<n;i++){
        int diff =arr[i]-arr[i-1];
        min = Math.min(min,diff);
     
       }

        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] == min) {
                ans.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
       return ans;

    }
}