package com.homework.HotelSystem;

import java.util.Scanner;

public class Hotel {
    private Room[][] rooms;

    public Hotel() {
        rooms = new Room[3][8];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (j <= 3) {
                    rooms[i][j] = new Room((i + 1) * 100 + j + 1, "单人房", true);
                } else if (j <= 6) {
                    rooms[i][j] = new Room((i + 1) * 100 + j + 1, "双人房", true);
                } else if (j <= 8) {
                    rooms[i][j] = new Room((i + 1) * 100 + j + 1, "豪华房", true);
                }
            }
        }
    }

    public void look() {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                System.out.print(rooms[i][j]);
            }
            System.out.println();
        }
    }

    public void Reservation(int no) {
        int n = no;
        int f = n / 100;
        int r = n % 100;
        Scanner sr = new Scanner(System.in);
        if (f > 0 & f < 4) {
            if (r > 0 & r < 9) {
                Room room = rooms[f - 1][r - 1];
                if (room.isStatus() == false) {
                    System.out.println("该房间已被占用，请重新选择房间：");
                    Reservation(sr.nextInt());
                } else {
                    room.setStatus(false);
                    System.out.println(no + "号房订房成功");
                }
            }
        } else {
            System.out.print("输入有误，请重新输入:");
            Reservation(sr.nextInt());
        }
    }

    public void Refund(int no) {
        int n = no;
        int f = n / 100;
        int r = n % 100;
        Scanner sr = new Scanner(System.in);
        if (f > 0 & f < 4) {
            if (r > 0 & r < 9) {
                Room room = rooms[f - 1][r - 1];
                if (room.isStatus() == true) {
                    System.out.println("该房间未使用或者在之前已经退房，请重新确认选择房间：");
                    Refund(sr.nextInt());
                } else {
                    room.setStatus(true);
                    System.out.println(no + "号房退房成功");
                }
            }
        } else {
            System.out.print("输入有误，请重新输入:");
            Refund(sr.nextInt());

        }
    }


}

