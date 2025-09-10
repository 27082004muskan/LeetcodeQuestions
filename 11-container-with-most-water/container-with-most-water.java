class Solution {
    public int maxArea(int[] height) {
        int n =height.length;
        int area =1;
        int maxArea = Integer.MIN_VALUE;
        int j =n-1;
        int i =0;
         while(i < j) {
            int water =0;
            // for(int j =i+1;j<n;j++){
            water = Math.min(height[i],height[j]);
            area = (j-i)*water;
              maxArea = Math.max(maxArea , area);
            // }
       
            if(height[i] < height[j]) {
                // i will increment in next iteration
                i++;
            } else {
                j--; // Move j inside the loop
            }

        }
     
        return maxArea;
    }
}