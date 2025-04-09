// class Solution {
//     public int[] countBits(int n) {
//         int result[] = new int[n+1];
//         if (n == 0)
//             return result;

//         result[1] = 1;

//         for (int i = 2; i <= n; i++) {
//             if (i % 2 == 0) {
//                 result[i] = result[i / 2];
//             } else {
//                 result[i] = result[i / 2] + 1;
//             }
//         }

//         return result;
//     }
// }

// ----------------------------------------2nd

// class Solution {
//     public int[] countBits(int n) {
//         int ans[] = new int[n + 1];

//         for (int i = 0; i <= n; i++) {
//             int count = 0;
//             int num = i;  // Use 'i' instead of 'n'
            
//             while (num != 0) {
//                 num = num & (num - 1);
//                 count++;
//             }
            
//             ans[i] = count; // Store count in ans[i]
//         }
//         return ans;
//     }
// }

//---------------------------------3

class Solution {
    public int count(int n){
        int count =0;
        while(n!=0){
            count+=(n&1);
            n=n>>1;
        }
        return count;
        }
    
     public int[] countBits(int n) {
        int temp[] = new int[n+1];
        if(n==0) return temp ;

        for(int i =1;i<=n;i++){
           temp[i]= count(i);
        }
         return temp;
     }
} 
     
