package com.test.service.pack02;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/23  21:27
 */
public class OneServiceImpl implements OneService {
    @Override
    public Object sayHi(String name,Integer age) {
        System.out.println(name+",好久没见你，又变帅了！");
        return name;
    }
}
