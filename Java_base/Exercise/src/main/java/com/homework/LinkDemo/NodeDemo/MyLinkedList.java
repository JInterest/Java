package com.homework.LinkDemo.NodeDemo;

/**
 * 单向链表
 * */
public class MyLinkedList {
    Node header=null;
    Object data;

    public MyLinkedList(Object data) {
        this.data = data;

    }

    public MyLinkedList() {
    }

    public  void add(Object data){
    if (null==header){
     header=new Node(data,null);
    }else {
        Node currentLastList=findLast(header);
        currentLastList.next=new Node(data,null);
    }

    }

    private Node findLast(Node node) {
        if (node.next==null){
            return node;
        }else return findLast(node.next);//递归 直到找到下一节点地址为空
    }
}
