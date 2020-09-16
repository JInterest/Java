package com.homework.the5;

public class Warship extends Weapon implements canAttack, canMove {

    public void Move() {
        System.out.println("Warship移动");
    }

    public void Attack() {
        System.out.println("Warship攻击");
    }

    @Override
    public String toString() {
        return "Warship";
    }
}
