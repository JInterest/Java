package cn.JInterest.atomic;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/09/10  14:14
 * @Description: 使用 AtomicReference 原子读写一个对象
 *                  AtomicStampedReference 解决CAS的ABA问题
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        AtomicReference<String> atomicReference = new AtomicReference<>("abc");
        AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference("abc",0);//带版本号
    }
}
