package com.homework.StackDemo;

public class test {
    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        MyStack myStack1=new MyStack();
        myStack.Push(new String[]{});
        myStack.Push(new String[]{});
        myStack.Push(new String[]{});
        myStack.Push(new String[]{});
        myStack.Push(new String[]{});
        myStack.Push(new String[]{});
        myStack.Push(new String[]{});
        myStack.Push(new String[]{});
        myStack.Push(new String[]{});
        myStack.Push(new String[]{});
        myStack.Push(new String[]{});
        System.out.println("--------------------------------------");
        myStack.Pop();
        myStack.Pop();
        myStack.Pop();
        myStack.Pop();
        myStack.Pop();
        myStack.Pop();
        myStack.Pop();
        myStack.Pop();


        System.out.println("--------------------------------------");
        myStack1.Pop();
    }
}
