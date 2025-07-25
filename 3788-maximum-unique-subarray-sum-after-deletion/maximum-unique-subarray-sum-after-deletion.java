class Solution {
    public int maxSum(int[] nums) {

//       int Currsum =0 , maxSum = Integer.MIN_VALUE ;
//       for(int i =1;i<nums.length;i++){
//         Currsum =nums[i-1];
// if(nums[i-1]!=nums[i]){
//     Currsum+=nums[i];
//      maxSum=Math.max(Currsum,maxSum);
// }else{
//     Currsum =0;

// }
//       } 
//       return maxSum; 

Set<Integer> set = new HashSet<>();

int sum =0;
int maxNeg = Integer.MIN_VALUE;

for(int num:nums)
{
    if(num<=0)
    maxNeg = Math.max(maxNeg , num);
    else if(!set.contains(num)){
        sum+=num ;
        set.add(num);
    }
}
return sum==0 ? maxNeg :sum;
    }
}


