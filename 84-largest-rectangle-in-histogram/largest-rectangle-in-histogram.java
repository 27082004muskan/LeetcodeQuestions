class Solution {
    public int largestRectangleArea(int[] heights) {
        int n =heights.length;
        // we need two stack for nse and pse
        Stack<Integer> st = new Stack<Integer>();
        int[] nse = new int[n];
         int[] pse = new int[n];
         //calculating nse of all elements 
         //will move from last - last ko stack mei push (index)
         st.push(n-1);
         nse[n-1]=n;
         //loop from 2nd last element to 0 
         for(int i =n-2;i>=0;i--){
            //agar apne se bada element mil rha hai to pop
            while(st.size()>0 && heights[st.peek()]>heights[i]){
             st.pop();
            }
            //if stack is empty than write n 
            if(st.size()==0) nse[i]=n;
            else nse[i]=st.peek();
            st.push(i);
        }
          



         //stack of empty karo 
        while(st.size()>0) st.pop();
            //calculate pse []- from start and first element will be 0

       st.push(0);
       pse[0]=-1;
       for(int i =1;i<=n-1;i++){
           while(st.size()>0 && heights[st.peek()]>=heights[i]){
             st.pop();
            }
             if(st.size()==0) pse[i]=-1;
            else pse[i]=st.peek();
              st.push(i);
       }




       //MAX AREA 
       int max =-1;
       for(int i =0;i<n;i++){
int area =heights[i]*(nse[i]-pse[i]-1);
max=Math.max(max,area);
       }
      
return max;

    }
}