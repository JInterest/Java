package com.homework.StackDemo;
/*
编写程序，使用一维数组，模拟栈数据结构。
        要求：
        1、这个栈可以存储java中的任何引用类型的数据。
        2、在栈中提供push方法模拟压栈。（栈满了，要有提示信息。）
        3、在栈中提供pop方法模拟弹栈。（栈空了，也有有提示信息。）
        4、编写测试程序，new栈对象，调用push pop方法来模拟压栈弹栈的动作。
*/

public class MyStack {
    private int index;
    private Object[] elements;


    public MyStack() {
        this.elements = new Object[10];
        this.index = -1;

    }

    public MyStack(Object[] elements) {
        this.elements = elements;
    }

    public void Push(Object obj) {
        if (index >= elements.length - 1) {
            System.out.println("MyStack已满，压栈失败");
            return;
        }
        index++;
        elements[index] = obj;
        System.out.println("压栈" + obj + "元素成功，栈针指向" + index);

    }

    public void Pop() {

        if (index < 0) {
            System.out.println("栈已空，弹栈失败");
            return;
        }
        System.out.println("弹栈" + elements[index] + "元素成功");
        index--;
        System.out.println("栈针指向" + index);

    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    public int getIndex() {
        return index;
    }

    public Object[] getElements() {
        return elements;
    }
}

