class Solution {
    public int findMinArrowShots(int[][] points) {
          if (points.length == 0) return 0;
        // bhaut badi value hai so we cant follow this technique 
        //we have to use traditional comparator technique
        //Arrays.sort(points , (a,b)-> a[1]-b[1]);
        // traditional state ... taht a,b mei swapping hogi -> when it will return positive1
        
        Arrays.sort(points , (a,b)->(a[1]<=b[1])?-1:1);
       int n =points.length;


        int point =1;
        int lastEnd = points[0][1];
        for(int i =1;i<n;i++){
            if(points[i][0]>lastEnd){
                point++;
            
                lastEnd=points[i][1];
            }
        }
        return point ;
    }
}