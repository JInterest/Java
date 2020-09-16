package com.homework.HotelSystem;

import java.util.Objects;

//学习中出现的问题  类Room继承了Hotel 创建对象时，导致在父类构造方法new子类对象，这样会造成循环调用构造方法
//Exception in thread "main" java.lang.StackOverflowError
public class Room  {
    private int no;
    private String type;
    private boolean status;

    public Room() {
    }

    public Room(int no, String type, boolean status) {
        this.no = no;
        this.type = type;
        this.status = status;
    }

    public String toString() {
        return "[" +no+"-"+type+"-"+(status?"空闲":"占用")+"]";
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getNo() {
        return no;
    }

    public String getType() {
        return type;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return no == room.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }
}
