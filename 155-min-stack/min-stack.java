import java.util.Stack;
class MinStack {
    private Stack<Integer> stack = new Stack<>(), minStack = new Stack<>();

    public void push(int value){
        stack.push(value);

        if(minStack.isEmpty() || value <= minStack.peek()){
            minStack.push(value);
        }
    }
    public void pop(){
        if(!stack.isEmpty()){
            if(stack.peek().equals(minStack.peek())){  //TC:push/pop/top/getMin=O(1)
                minStack.pop();                        //SC:O(N)
            }
            stack.pop();
        }
    }
    public int top(){
        return stack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }
}    

//     public MinStack() {
        
//     }
    
//     public void push(int value) {
        
//     }
    
//     public void pop() {
        
//     }
    
//     public int top() {
        
//     }
    
//     public int getMin() {
        
//     }
// }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */