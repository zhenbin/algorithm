package com.zhenbin.lzb.java.classloader;

/**
 * Created by zhenbin.lzb on 2016/9/6.
 */
public class NoClassDefFoundErrorDemo {
    /**
     * java.lang.ClassNotFoundException
     * This exception indicates that the class was not found on the classpath.
     * This indicates that we were trying to load the class definition,
     * and the class did not exist on the classpath.
     *
     * java.lang.NoClassDefFoundError
     * This exception indicates that the JVM looked in its internal class definition data structure
     * for the definition of a class and did not find it.
     * This is different than saying that it could not be loaded from the classpath.
     * Usually this indicates that we previously attempted to load a class from the classpath,
     * but it failed for some reason - now we're trying to use the class again (and thus need to load it,
     * since it failed last time), but we're not even going to try to load it,
     * because we failed loading it earlier (and reasonably suspect that we would fail again).
     * The earlier failure could be a ClassNotFoundException or an ExceptionInInitializerError
     * (indicating a failure in the static initialization block) or any number of other problems.
     * The point is, a NoClassDefFoundError is not necessarily a classpath problem.
     */
    public static void main(String[] args) {
        try {
            // The following line would throw ExceptionInInitializerError
            SimpleCalculator calculator1 = new SimpleCalculator();
        } catch (Throwable t) {
            System.out.println("��ʼ��ʱ�Ĵ���" + t);
        }
        // The following line would cause NoClassDefFoundError
        SimpleCalculator calculator2 = new SimpleCalculator();
    }

}