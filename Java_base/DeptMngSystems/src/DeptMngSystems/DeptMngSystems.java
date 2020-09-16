package DeptMngSystems;

import DAO.DeptDao;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author AJun
 * @version 1.0
 * @date 2020/5/1 21:35
 * 设计一个部门管理系统
 * 1.实现登陆验证（简单版），部门名字和部门编号一致就可以登陆。
 * 2.可以对部门数据进行增删改查。
 */
public class DeptMngSystems {
    public static void main(String[] args) {
        //---登陆验证
        System.out.println("-------欢迎使用部门管理系统-------");
        System.out.println("------------ 请登陆--------------");
        DeptMngSystems.login();


    }

    private static int flag = 0;
    private static DeptDao deptDao = new DeptDao();
    private static Scanner sc = new Scanner(System.in);
    private static String deptno, dname, loc;

    public static void login() {
        System.out.println("请输入账号：");
        dname = sc.nextLine();
        System.out.println("请输入密码：");
        deptno = sc.nextLine();
        flag = deptDao.Verify(dname, deptno);
        if (flag == 1) {
            System.out.println("登陆成功");
            initSystems();
        } else {
            System.out.println("验证失败！");
            login();
        }
    }

    private static void initSystems() {
        System.out.println("^^^^^^^请输入以下功能对应编号进行操作^^^^^^^");
        System.out.println("————————————————1.增加部门————————————————");
        System.out.println("————————————————2.删除部门————————————————");
        System.out.println("————————————————3.更新部门————————————————");
        System.out.println("————————————————4.查看部门————————————————");
        System.out.println("————————————————0.退出系统————————————————");


        while (true) {
            flag = sc.nextInt();
            if (flag == 1) {
                System.out.println("请输入新的部门的编号：");
                deptno = sc.next();
                System.out.println("请输入新的部门的名字：");
                dname = sc.next();
                System.out.println("请输入新的部门的地址：");
                loc = sc.next();
                flag = deptDao.add(deptno, dname, loc);

                if (flag == 1) {
                    System.out.println("添加成功！请继续，退出系统输入0");
                } else {
                    System.out.println("添加失败！重新输入请按1");
                }
            } else if (flag == 2) {
                System.out.println("请输入部门的编号：");
                deptno = sc.next();
                flag = deptDao.del(deptno);
                if (flag == 1) {
                    System.out.println("删除成功！请继续，退出系统输入0");
                } else {
                    System.out.println("删除失败！重新请按2");
                }
            } else if (flag == 3) {
                System.out.println("请输入原部门的编号：");
                deptno = sc.next();
                System.out.println("请输入新部门的名字：");
                dname = sc.next();
                System.out.println("请输入新部门的地址：");
                loc = sc.next();
                flag = deptDao.update(deptno, dname, loc);
                if (flag == 1) {
                    System.out.println("修改成功！请继续，退出系统输入0");
                } else {
                    System.out.println("修改失败！重新输入请按3");
                }
            } else if (flag == 4) {
                List<Dept> list = new ArrayList();
                list = deptDao.select();
                Iterator<Dept> it = list.iterator();
                while (it.hasNext()) {
                    Dept d = it.next();
                    System.out.println("--" + d.getDeptno() + "  " + d.getDname() + "  " + d.getLoc() + "--");
                    //输出后将数据从集合中删除 避免线程插叙重复

                }
            } else if (flag == 0) {
                System.out.println("正在关闭系统......");
                break;
            }
        }
    }
}
