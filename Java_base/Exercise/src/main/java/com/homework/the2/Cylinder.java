package com.homework.the2;
/*（1）定义接口A，里面包含值为3.14的常量PI和抽象方法double area()。
（2）定义接口B，里面包含抽象方法void setColor(String c)。
（3）定义接口C，该接口继承了接口A和B，里面包含抽象方法void volume()。
（4）定义圆柱体类Cylinder实现接口C，该类中包含三个成员变量：底圆半径radius、
圆柱体的高height、颜色color。
（5）创建主类来测试类Cylinder。
*/

   public class Cylinder implements C{
       public int radius;
       public int height;
       public String color;

       public Cylinder() {
       }

       public Cylinder(int radius, int heigjt, String color) {
           this.radius = radius;
           this.height = heigjt;
           this.color = color;
       }

       public int getRadius() {
            return radius;
        }

        public int getHeight() {
            return height;
        }

        public String getColor() {
            return color;
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public double area() {
            double a =  (this.radius*2*A.PI*A.PI)+(2*this.radius*A.PI*this.height);
            System.out.println("面积："+a);
            return a;
        }

        @Override
        public void setColor(String c) {
            this.color = c;
        }

        @Override
        public void volume() {
            double v=  (this.radius*2*A.PI*A.PI*this.height);
            System.out.println("体积是:"+v);
        }


     public String toString() {
           return "圆柱体的半径："+radius+"\n"
                   +"高："+ height +"\n"
                   +"颜色："+color;
       }


   }

