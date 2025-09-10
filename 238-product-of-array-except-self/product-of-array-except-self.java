class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;   // 4
        int[] ans = new int[n];   //4 
       
        // for(int i =0;i<n;i++){ 
        //      int a =1;   // i=0 
        //     for(int j =0;j<n;j++){  // j=0 ,1 ,2 ,3
        //         if(i!=j){              // 0=0 , 0!=1 , 0!=2 , 0!=3

        //             a*=nums[j];   //ans = 2 *3 = 6 , 24
        //             ans[i]=a;   // ans[0]=6 ,24
        //         }else{
        //             continue;
        //         }
        //     }
        // }

        ans[0]=1;
        for(int i =1;i<n;i++){
            ans[i]=ans[i-1]*nums[i-1];
        }
        int suffix=1;
        for(int j =n-1;j>=0;j--){
            ans[j]=ans[j]*suffix;
            suffix = suffix*nums[j];
        }
        return ans;
          }
}