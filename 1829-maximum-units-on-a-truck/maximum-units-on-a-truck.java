// class Solution {
//     public int maximumUnits(int[][] boxTypes, int truckSize) {
//        Arrays.sort(boxTypes ,(a,b)-> b[1]-a[1]);// sorting end value in decreasing order 
//     int n = boxTypes.length;
//     int load=0;
      

//         for(int i =0;i<n;i++){
//             int currLoad = boxTypes[i][1];
//             if(currLoad<= truckSize){
//             load+=(boxTypes[i][0]* boxTypes[i][1]);
//             }
//         }
//         return load ;
//     }
// }


// class Solution {
//     public int maximumUnits(int[][] boxTypes, int truckSize) {
//         // Sort by units per box in decreasing order
//         Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

//         int n = boxTypes.length;
//         int load = 0;

//         for (int i = 0; i < n && truckSize > 0; i++) {
//             int boxCount = boxTypes[i][0];       // number of boxes available
//             int unitsPerBox = boxTypes[i][1];    // units per box

//             int boxesToTake = Math.min(truckSize, boxCount);
//             load += boxesToTake * unitsPerBox;
//             truckSize -= boxesToTake;
//         }

//         return load;
//     }
// }



class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort by units per box in decreasing order
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int totalUnits = 0;

        for (int[] box : boxTypes) {
            int boxCount = box[0];      // number of boxes
            int unitsPerBox = box[1];

            // Take as many as the truck can hold
            int boxesToTake = Math.min(truckSize, boxCount);

            totalUnits += boxesToTake * unitsPerBox;
            truckSize -= boxesToTake;

            if (truckSize == 0) break; // Truck is full
        }

        return totalUnits;
    }
}

