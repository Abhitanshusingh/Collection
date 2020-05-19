package com.bridgelabz.stack;

import com.bridgelabz.exception.MyStackException;

public class MyStack {
    private Object elements[];
    private int capacity;
    private int top;

    public MyStack(int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
        this.top = -1;
    }

    public boolean push(Object data) throws MyStackException {
        if (capacity - 1 == top)
            throw new MyStackException(MyStackException.ExceptionType.STACK_OVER_FLOW, "Stack is over flow");
        elements[++top] = data;
        return true;
    }

    public Object pop() throws MyStackException {
        if (top == -1)
            throw new MyStackException(MyStackException.ExceptionType.STACK_UNDER_FLOW, "Stack is under flow");
        capacity--;
        return elements[top--];
    }

    public int size() {
        return top + 1;
    }

    public Object peek() throws MyStackException {
        if (top == -1)
            throw new MyStackException(MyStackException.ExceptionType.STACK_UNDER_FLOW, "Stack is under flow");
        return elements[top];
    }

    public String toString() {
        String print = "[";
        for (int index = 0; index <= top; index++) {
            print += elements[index];
            if (index < top)
                print = print + ",";
        }
        return print + "]";
    }

    public static void main(String[] args) throws MyStackException {
        MyStack myStack = new MyStack(10);
        myStack.push(2);
        myStack.push(3);
        myStack.push(5);
        myStack.push(4);
        myStack.pop();
        System.out.println(myStack.size());
        System.out.println(myStack.peek());
        System.out.println(myStack);
    }
}
