package com.homework.the5;

public class GaoShePao extends Weapon implements canAttack {

    public void Attack() {
        System.out.println("高射炮攻击！！！");
    }

    public String toString() {
        return "高射炮";
    }
}
