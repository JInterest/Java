package com.homework.the1;

public class Homework1_1 {

    public static void main(String[] args) {

        Vehicle v = new Vehicle();
        v.move();
        v.setSpeed(3);
        v.setSize(5);
        System.out.println("Speed:" + v.getSpeed() + "\t" + "Size:"
                + v.getSize());
        v.speedUp(-2);
        System.out.println("Speed:" + v.getSpeed());

        v.speedDown(6);
        System.out.println("Speed:" + v.getSpeed());
    }
}
     class Vehicle{
        private int speed;
        private int size;
       
        public Vehicle() {
        }

        public Vehicle(int speed, int size) {
            this.speed = speed;
            this.size = size;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getSpeed() {
            return speed;
        }

        public int getSize() {
            return size;
        }

        public void move(){
            System.out.println("交通工具：大巴：启动");
        }

        public void speedUp(int addspeed){
            //this 就是当前(交通工具)对象
            int a=addspeed;
            int sum=this.getSpeed()+addspeed;
       /*     if (a<0 || sum>0){
                System.out.println("加速必须大于0");
                return;
            }
            this.setSpeed(sum);*/
       if (a>0){
           this.setSpeed(sum);
       }else{
           System.out.println("加速必须大于0");
       }

        }

        public void speedDown(int subspeed){
            int s=subspeed;
            int sum=this.getSpeed()-subspeed;

            if (s>0 && sum>0 ){
                this.setSpeed(sum);
            }else{
                System.out.println("减速之后速度必须大于0");
            }

        }
    }




