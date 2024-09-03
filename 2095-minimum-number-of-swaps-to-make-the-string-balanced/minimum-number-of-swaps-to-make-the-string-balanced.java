class Solution {
    public int minSwaps(String s) {
        int open=0 , close =0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='['){
              //  stack.push(ch);
                open++;
            }else{
              
                    if(open<=0){
                        close++;
                    }
                else{
                    //stack.pop();
                    open--;
                }
            }
        }

        return (close+1)/2;
    }
    }
