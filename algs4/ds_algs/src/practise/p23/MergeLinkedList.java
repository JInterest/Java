package practise.p23;

import leetcode.link.MyLinkedList;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/08/23  12:09
 * @Description:合并两个有序单向链表
 */
public class MergeLinkedList {
    public MyLinkedList merge(MyLinkedList l1, MyLinkedList l2) {

        MyLinkedList res = new MyLinkedList();
        MyLinkedList.Node header1 = l1.getHeader();
        MyLinkedList.Node header2 = l2.getHeader();
        //先把第一个队列加入
        while (header1 != null ) {
            res.addAtTail(header1.getData());
            header1 = header1.getNext();
        }
        //判断第二个队列是否都大于第一个队列尾部
        if (header2!=null && header2.getData()>res.findIndex(res.getSize()-1).getData()){
            while (header2!=null){
                res.addAtTail(header2.getData());
                header2=header2.getNext();
            }
            return res;
        }
        //按大小插入
        int index = 0;
        while (res.findIndex(index)!=null){
            while (header2.getData()<res.findIndex(index).getData()){
                int value = header2.getData();
                if (index==0){
                    res.addAtHead(value);
                }else {
                    //小于则将数据代替当前位置 后面往后推
                    res.addAtIndex(index,value);
                }
                header2=header2.getNext();
            }
            index++;
        }
        return res;

    }

    public static void main(String[] args) {
        MyLinkedList l1 = new MyLinkedList();
        l1.addAtTail(1);
        l1.addAtTail(4);
        l1.addAtTail(5);
        l1.addAtTail(7);
        l1.addAtTail(8);
        System.out.println(l1.getHeader().getData());
        MyLinkedList l2 = new MyLinkedList();
        l2.addAtTail(3);
        l2.addAtTail(4);
        l2.addAtTail(6);
        l2.addAtTail(9);
        System.out.println(l2.getHeader().getData());
        System.out.println("------------------");
        MergeLinkedList m = new MergeLinkedList();
        MyLinkedList merge = m.merge(l1, l2);
        MyLinkedList.Node header = merge.getHeader();

        while (header != null) {
            System.out.println(header.getData());
            header = header.getNext();
        }

    }
}
