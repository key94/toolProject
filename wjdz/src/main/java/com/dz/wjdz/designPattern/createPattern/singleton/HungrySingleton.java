package com.dz.wjdz.designPattern.createPattern.singleton;

/**
 * @ClassName HungrySingleton
 * @Description 饿汉式
 * 饿汉式是典型的空间换时间，当类装载的时候就会创建类实例，不管你用不用，先创建出来，然后每次调用的时候，就不需要判断了，节省了运行时间
 * @Author xhk
 * @Date 2020/5/18 16:22
 * @Version 1.0
 */
public class HungrySingleton {
    private static HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton() {}

    private static HungrySingleton getInstance(){
        return singleton;
    }

}
