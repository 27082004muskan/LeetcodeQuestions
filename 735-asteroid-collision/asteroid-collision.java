class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        //IF STACK IS EMPTY OR POSITIVE VALUE ARRIVES THEN PERFORM BLIND INSERTION
       for(int i=0;i<asteroids.length;i++) {
           if (stack.isEmpty() || asteroids[i] > 0) {
               //if they are greater than zero then we have to push
               //blind insertion
              stack.push(asteroids[i]);
           }else{
               //stack is not empty and we have recieved the negative number
               while (!stack.isEmpty()){
                   int top=stack.peek();
                   //if top is -ve then it will be a blind insertion(both -ve)
                   if(top<0){
                       stack.push(asteroids[i]);
                       break;
                   }
                   int modVal =Math.abs(asteroids[i]);
                       if(modVal==top){
                           //if both and modval both are same then explosion
                           stack.pop();
                           break;
                       }else if (modVal<top){
                           break;
                       }else{
                           stack.pop();
                           //if again stack is empty then blind insertion
                           if(stack.isEmpty()){
                               stack.push(asteroids[i]);
                               break;
                           }
                       }
                   }
               }
           }



       int ansArray[] = new int[stack.size()];
       for(int i=stack.size()-1;i>=0;i--){
           ansArray[i]=stack.pop();

       }
       return ansArray;
    
    }
}