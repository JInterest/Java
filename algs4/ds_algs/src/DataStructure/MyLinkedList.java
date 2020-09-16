package DataStructure;


/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/08/29  0:28
 * @Description: 单向链表
 */
public class MyLinkedList {

    private Node header;
    private int data;
    private int size;


    public MyLinkedList() {
    }

    public MyLinkedList(int data) {
        this.data = data;
    }

    //---------------------------------------------------

    public int getByIndex(int index) {
        if (index>=size || index<0) return -1;
        return findIndex(index).getData();
    }

    public void addAtHead(int data) {
        if (null==header){
            header=new Node(data,null);
        }else {
            Node newHeader = new Node(data,header);
            header=newHeader;
        }
        size++;
    }

    public void addAtTail(int data) {
        if (null==header){
            header=new Node(data,null);
        }else {
            //找到最后一个
            Node currentLastList=findLast(header);
            currentLastList.next=new Node(data,null);
        }
        size++;
    }

    //如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
    public void addAtIndex(int index, int data) {
        if (index==size){
            this.addAtTail(data);
            return;
        }

        if (index>size) return;

        if (index<=0){
            this.addAtHead(data);
            return;
        }

        Node prev = findIndex(index-1);
        Node newNode = new Node(data,prev.getNext());
        prev.setNext(newNode);
        size++;
    }

    public void deleteAtIndex(int index) {

        if (index<0 || index>=size) return;

        if (index==0){
            header=header.getNext();
            size--;
            return;
        }

        Node node=findIndex(index);
        //如果是最后一个
        if (index==size-1){
            if (node!=null){
                Node prev = findIndex(index-1);
                prev.setNext(null);
                size--;
            }
            return;
        }
        if (node!=null){
            Node prev = findIndex(index-1);
            Node next = node.getNext();
            if (next!=null){
                prev.setNext(next);
            }
            size--;
        }
    }

    public Node findLast(Node node) {
        if (node.next==null){
            return node;
        }else return findLast(node.next);//递归 直到找到下一节点地址为空
    }

    public Node findIndex(int index) {
        if (index==0) return header;
        if (index>=size) return null;

        Node indexNode= header.getNext();
        while (index>=2){ //前面已经处理了 0 1
            indexNode=indexNode.getNext();
            index--;
        }
        return indexNode;
    }


    //-------------------------------------------
    public Node getHeader() {
        return header;
    }

    public void setHeader(Node header) {
        this.header = header;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //-----------------------------------------
    private static class Node {
        int var;
        Node next;
        //双向链表
        // Node pre;

        public Node() {
        }

        public Node(int data, Node next) {
            this.var = data;
            this.next = next;
        }

        public int getData() {
            return var;
        }

        public void setData(int data) {
            this.var = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
