package com.homework.NodeDemo;
/**
 * 编写程序实现单向链表数据结构：
 * 	public class Node {
 * 		Object data;
 * 		Node next;
 *        }
 * 	public class MyLinkedList{
 * 		Node header;
 * 		....
 * 		// 添加数据的方法
 * 		// 删除数据的方法
 * 		// 修改数据的方法
 * 		// 查找数据的方法
 * 		// 打印集合中每个元素的方法
 *    }
 *
 * 	最后编写测试程序
 * */

public class MyLinkedList {

    Node header;
    Object data;
    int size;

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
    size++;
    }

    public void remove(Object data){
    }

    private Node findLast(Node node) {
        if (node.next==null){
            return node;
        }else return findLast(node.next);//递归 直到找到下一节点地址为空
    }
    public int size(){
        return size;
    }
}
