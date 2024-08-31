class Solution {
    public boolean isValid(String s) {
        
    
     int n =s.length();
        if(n%2!=0){
            return false;
        }
    Stack<Character> stack = new Stack<>();
        for(int i =0; i<n;i++){
            //converting string into characters
            char ch =s.charAt(i);
            //pushing characters into stack
            if( ch=='('|| ch=='['|| ch=='{'){
                stack.push(ch);
            }
            else{
                //agar stack he empty hai
                if(stack.isEmpty()){
                    return false;
                }
                //finding top of stack
                char top = stack.peek();
               if (ch == ')' && top != '(') {
                    return false;
                } else if (ch == ']' && top != '[') {
                    return false;
                } else if (ch == '}' && top != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return (stack.size()==0);
    }
}