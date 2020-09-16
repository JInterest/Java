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
 * ���һ�����Ź���ϵͳ
 * 1.ʵ�ֵ�½��֤���򵥰棩���������ֺͲ��ű��һ�¾Ϳ��Ե�½��
 * 2.���ԶԲ������ݽ�����ɾ�Ĳ顣
 */
public class DeptMngSystems {
    public static void main(String[] args) {
        //---��½��֤
        System.out.println("-------��ӭʹ�ò��Ź���ϵͳ-------");
        System.out.println("------------ ���½--------------");
        DeptMngSystems.login();


    }

    private static int flag = 0;
    private static DeptDao deptDao = new DeptDao();
    private static Scanner sc = new Scanner(System.in);
    private static String deptno, dname, loc;

    public static void login() {
        System.out.println("�������˺ţ�");
        dname = sc.nextLine();
        System.out.println("���������룺");
        deptno = sc.nextLine();
        flag = deptDao.Verify(dname, deptno);
        if (flag == 1) {
            System.out.println("��½�ɹ�");
            initSystems();
        } else {
            System.out.println("��֤ʧ�ܣ�");
            login();
        }
    }

    private static void initSystems() {
        System.out.println("^^^^^^^���������¹��ܶ�Ӧ��Ž��в���^^^^^^^");
        System.out.println("��������������������������������1.���Ӳ��š�������������������������������");
        System.out.println("��������������������������������2.ɾ�����š�������������������������������");
        System.out.println("��������������������������������3.���²��š�������������������������������");
        System.out.println("��������������������������������4.�鿴���š�������������������������������");
        System.out.println("��������������������������������0.�˳�ϵͳ��������������������������������");


        while (true) {
            flag = sc.nextInt();
            if (flag == 1) {
                System.out.println("�������µĲ��ŵı�ţ�");
                deptno = sc.next();
                System.out.println("�������µĲ��ŵ����֣�");
                dname = sc.next();
                System.out.println("�������µĲ��ŵĵ�ַ��");
                loc = sc.next();
                flag = deptDao.add(deptno, dname, loc);

                if (flag == 1) {
                    System.out.println("��ӳɹ�����������˳�ϵͳ����0");
                } else {
                    System.out.println("���ʧ�ܣ����������밴1");
                }
            } else if (flag == 2) {
                System.out.println("�����벿�ŵı�ţ�");
                deptno = sc.next();
                flag = deptDao.del(deptno);
                if (flag == 1) {
                    System.out.println("ɾ���ɹ�����������˳�ϵͳ����0");
                } else {
                    System.out.println("ɾ��ʧ�ܣ������밴2");
                }
            } else if (flag == 3) {
                System.out.println("������ԭ���ŵı�ţ�");
                deptno = sc.next();
                System.out.println("�������²��ŵ����֣�");
                dname = sc.next();
                System.out.println("�������²��ŵĵ�ַ��");
                loc = sc.next();
                flag = deptDao.update(deptno, dname, loc);
                if (flag == 1) {
                    System.out.println("�޸ĳɹ�����������˳�ϵͳ����0");
                } else {
                    System.out.println("�޸�ʧ�ܣ����������밴3");
                }
            } else if (flag == 4) {
                List<Dept> list = new ArrayList();
                list = deptDao.select();
                Iterator<Dept> it = list.iterator();
                while (it.hasNext()) {
                    Dept d = it.next();
                    System.out.println("--" + d.getDeptno() + "  " + d.getDname() + "  " + d.getLoc() + "--");
                    //��������ݴӼ�����ɾ�� �����̲߳����ظ�

                }
            } else if (flag == 0) {
                System.out.println("���ڹر�ϵͳ......");
                break;
            }
        }
    }
}
