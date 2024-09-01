class Solution {
    public int minAddToMakeValid(String s) {
        //  Stack<Character> stack = new Stack<>();
        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);
        //     if (ch == '(') {
        //         stack.push(ch);
        //     } else {
        //         //insert incase  of invalid pair }} or close comes before open
        //         if (stack.isEmpty() || stack.peek() == ')') {
        //             stack.push(ch);
        //         } else {
        //             //pop in case of valid parenthesis
        //             stack.pop();
        //         }
        //     }
        // }
        // return stack.size();



         int open =0, close=0;
        // Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
               // stack.push(ch);
                open++;
            } else {
                //insert incase  of invalid pair }} or close comes before open
              //  if (stack.isEmpty() || stack.peek() == '}') {
                if(open<=0 ){
                   // stack.push(ch);
                    close++;
                } else {
                    //pop in case of valid parenthesis
                   // stack.pop();
                    open--;
                }
            }
        }
        return (open+close); //stack.size();
    }
    }
