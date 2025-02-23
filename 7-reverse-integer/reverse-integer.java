class Solution {
    public int reverse(int x) {
        int n=x;
        int flag=0,sum=0;
        if(n<0){
            n=(-1)*n;
            flag=1;
        }
        while(n>0) {
            int d=n%10;
            if(sum > Integer.MAX_VALUE/10 || sum < Integer.MIN_VALUE/10)
            return 0;
            sum=sum*10+d;
            n/=10;
        }
        if (flag==1) {
            return ((-1)*sum);
        }
        else
            return sum;
    }
}