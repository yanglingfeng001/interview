package Leetcode;

import java.util.Stack;

public class StackToQue {
    //双栈实现队列
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack2.push(node);
    }

    public int pop() {
        if(!stack1.empty())//如果栈一不为空则弹出栈一即可
            return stack1.pop();
        while(!stack2.empty())
        {
            stack1.push(stack2.pop());
        }
        return stack1.pop();
    }
}
