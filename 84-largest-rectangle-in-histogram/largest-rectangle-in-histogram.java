class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] right = new int[n];
        int[] left = new int[n];
        Stack<Integer> st = new Stack<>();

        //next smallest right 
         

         for(int i =0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                right[st.peek()]=i;
                st.pop();
            }
            st.push(i);
         }
         while(!st.isEmpty()){
            right[st.peek()]=n;
            st.pop();
         }
        // right smallest right
        
         for(int i =n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                left[st.peek()]=i;
                st.pop();
            }
            st.push(i);
         }
        while(!st.isEmpty()){
            left[st.peek()]=-1;
            st.pop();
         }

         int ans =0;
         for(int i =0;i<n;i++){
           ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));  // ✅ Correct

         }
         return ans ;
    }
}