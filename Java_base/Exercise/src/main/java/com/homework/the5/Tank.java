package com.homework.the5;

public class Tank extends Weapon implements canMove, canAttack {
    public void Move() {
        System.out.println("Tank移动");
    }

    public void Attack() {
        System.out.println("Tank攻击");
    }
    @Override
    public String toString() {
        return "Tank";
    }
}
