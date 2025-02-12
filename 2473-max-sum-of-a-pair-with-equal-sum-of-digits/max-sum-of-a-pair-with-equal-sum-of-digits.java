class Solution {
    public int getDigitSum(int num){
        int sum=0;
        while(num>0){
            sum+=(num%10);
            num=num/10;
        }
        return sum ;
    }
    public int maximumSum(int[] nums) {
    int map[]=new int[82];
    int ans=-1;
    for(int num:nums){
        int digitSum=getDigitSum(num);
        if(map[digitSum]>0){
            int prevNum=map[digitSum];
            ans=Math.max(prevNum+num,ans);
            map[digitSum]= Math.max(prevNum,num);
        }else{
            map[digitSum]=num;
        }
    }
    return ans;
    }
} 