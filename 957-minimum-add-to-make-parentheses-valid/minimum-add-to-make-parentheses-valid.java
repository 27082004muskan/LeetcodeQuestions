class Solution {
    public int minAddToMakeValid(String s) {
         Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                //insert incase  of invalid pair }} or close comes before open
                if (stack.isEmpty() || stack.peek() == ')') {
                    stack.push(ch);
                } else {
                    //pop in case of valid parenthesis
                    stack.pop();
                }
            }
        }
        return stack.size();
    }
}