package com.homework.the5;

public class Army {
    private Weapon[] w;
    private int n;
    private int h=0;//武器数量

    public void setMax(int n) {
        this.n = n;
    }

    public int getMax() {
        return n;
    }

    public Army(int n) {
        this.n=n;
        w=new Weapon[n];
        System.out.println("您最多拥有"+n+"个武器。");
    }
    public void addWeapon(Weapon weapon){
        if (h<getMax()){
            w[h]=weapon;
            System.out.println("添加武器"+weapon+"成功。");
            h++;
        }else System.out.println("警告：武器库已满！！！");
    }
    public void attackAll(){
        System.out.println("   所有武器开启攻击：");
        for (int j = 0; j <h ; j++) {
            if(w[j] instanceof canAttack){
                canAttack ct= (canAttack) w[j];
                System.out.print("第"+(j+1)+"种武器：");
                ct.Attack();
            }

        }
    }
    public void  moveAll(){
        System.out.println("    -全军出击-");
        for (int j = 0; j <h ; j++) {
            if (w[j] instanceof canMove){
                canMove cm=(canMove) w[j];
                System.out.print("第"+(j+1)+"种武器：");
                cm.Move();
            }
        }

    }
}
