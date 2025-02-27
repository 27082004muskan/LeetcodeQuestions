class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry =0;
        int i =a.length()-1;
        int j =b.length()-1;
        while(i>=0|| j>=0){
//             int x =0;
//             int y =0;
//             if (i>=0) {
//   x =a.charAt(i)-'0';
//             }else{
//                  y=0;
//             }
           
//             if(j>=0){
//     y=b.charAt(j)-'0';
//             } else{
//                  y=0;
//             }
         
        //  OR I CAN SHORTEN IT LIKE :
        int x = (i>=0)? a.charAt(i)-'0':0;
          int y = (j>=0)? b.charAt(j)-'0':0;

            int sum=x+y+carry;
            result.append(sum%2);
            carry=sum/2;
            i--;
            j--;
        }
        if(carry>0){
            result.append(carry);
        }
        return result.reverse().toString();
    }
}