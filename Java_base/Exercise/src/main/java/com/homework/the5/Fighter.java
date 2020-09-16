package com.homework.the5;

public class Fighter extends Weapon implements canAttack, canMove {
    public void Move() {
        System.out.println("Fighter移动");
    }

    public void Attack() {
        System.out.println("Fighter攻击");
    }
    public String toString() {
        return "Fighter";
    }
}
