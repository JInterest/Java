package cn.JInterest.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/09/10  13:11
 * @Description:原子更新数组
 */
public class AtomicIntegerArrayDemo {
    public static void main(String[] args) {
        //1) 创建原子数组
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);
        System.out.println( atomicIntegerArray ); //[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

        //2) 返回指定位置元素
        System.out.println( atomicIntegerArray.get(0)); //0
        System.out.println( atomicIntegerArray.get(1)); //0

        //3)设置指定位置的元素
        atomicIntegerArray.set(0, 10);//在设置数组元素的新值时, 同时返回数组元素的旧值
        System.out.println( atomicIntegerArray.getAndSet(1, 11) ); //0
        System.out.println( atomicIntegerArray ); //[10, 11, 0, 0, 0, 0, 0, 0, 0, 0]

        //4)修改数组元素的值,把数组元素加上某个值
        System.out.println( atomicIntegerArray.addAndGet(0, 22) ); //32
        System.out.println( atomicIntegerArray.getAndAdd(1, 33)); //11
        System.out.println( atomicIntegerArray ); //[32, 44, 0, 0, 0, 0, 0, 0, 0, 0]

        // 5)CAS 操作
        // 如果数组中索引值为 0 的元素的值是 32 , 就修改为 222
        System.out.println( atomicIntegerArray.compareAndSet(0, 32, 222)); //true
        System.out.println( atomicIntegerArray ); //[222, 44, 0, 0, 0, 0, 0, 0, 0, 0]
        System.out.println( atomicIntegerArray.compareAndSet(1, 11, 333)); //false
        System.out.println(atomicIntegerArray);

        //6)自增/自减
        System.out.println( atomicIntegerArray.incrementAndGet(0) ); //223, incrementAndGet相当于前缀 ++i
        System.out.println( atomicIntegerArray.getAndIncrement(1)); //44, getAndIncrement相当于后缀 i++
        System.out.println( atomicIntegerArray ); //[223, 45, 0, 0, 0, 0, 0, 0, 0, 0]
        System.out.println( atomicIntegerArray.decrementAndGet(2)); //-1
        System.out.println( atomicIntegerArray); //[223, 45, -1, 0, 0, 0, 0, 0, 0, 0]
        System.out.println( atomicIntegerArray.getAndDecrement(3)); //0
        System.out.println( atomicIntegerArray ); //[223, 45, -1, -1, 0, 0, 0, 0, 0, 0]
    }
}
