package com.dz.wjdz.designPattern.createPattern.singleton;

/**
 * @ClassName LazySingleton
 * @Description 懒汉式
 * 优点：在获取实例的方法中，进行实例的初始化，节省系统资源
 * 缺点：①如果获取实例时，初始化工作较多，加载速度会变慢，影响系统系能
 *      ②每次获取实例都要进行非空检查，系统开销大
 *      ③非线程安全，当多个线程同时访问getInstance()时，可能会产生多个实例
 * @Author xhk
 * @Date 2020/5/18 16:22
 * @Version 1.0
 */
public class LazySingleton {
    private static LazySingleton singleton = null;

    private LazySingleton(){}

    // 不加锁
    public static LazySingleton getSingleton(){
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }

    // 加同步锁，优点：线程安全，缺点：每次获取实例都要加锁，耗费资源，其实只要实例已经生成，以后获取就不需要再锁了
    public synchronized static LazySingleton getInstance1() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }

    // 双重检查锁,优点：线程安全，进行双重检查，保证只在实例未初始化前进行同步，效率高 缺点：还是实例非空判断，耗费一定资源
    public static LazySingleton getInstance2() {
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }

    // 静态内部类,优点：既避免了同步带来的性能损耗，又能够延迟加载
    private static class SingletonHolder {
        private static final LazySingleton SINGLETON = new LazySingleton();
    }

    public static LazySingleton getInstance3() {
        return SingletonHolder.SINGLETON;
    }

    /*
        1、防止反射
           定义一个全局变量，当第二次创建的时候抛出异常

        2、防止克隆破坏
           重写clone(),直接返回单例对象

        3、防止序列化破坏
           添加readResolve(),返回Object对象
     */

}