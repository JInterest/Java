package leetcode.queue_stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/07/17  14:01
 * @Description:
 */
class MinStack {
    private List<Integer> data;
    private int min=Integer.MAX_VALUE;;

    /** initialize your data structure here. */
    public MinStack() {
        this.data=new ArrayList();
    }

    public void push(int x) {
        if(x<=min){
            data.add(min);
            min=x;
        }
        data.add(x);
    }

    public void pop() {
        if(isEmpty()) throw  new RuntimeException("此栈已空");
        if(top()==min){
            data.remove(data.size()-1);
            min=top();
            data.remove(data.size()-1);
            return;
        }
        data.remove(data.size()-1);

    }

    public int top() {
        if(isEmpty()) throw  new RuntimeException("此栈已空");
        return data.get(data.size()-1);
    }

    public int getMin() {
        if(isEmpty()) throw  new RuntimeException("此栈已空");

        return min;
    }
    public Boolean isEmpty(){
        return data.isEmpty();
    }



    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}
