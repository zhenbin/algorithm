package com.zhenbin.lzb.java.classloader;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zhenbin.lzb on 2016/9/7.
 */
public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String loadPath = "D:\\code\\algorithm\\java\\new-target\\";

        try {
            //read class
            String fileName = loadPath + name.replace(".", "\\") + ".class";
            FileInputStream is = new FileInputStream(new File(fileName));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = is.read()) != -1) {
                baos.write(b);
            }
            byte[] buffer = baos.toByteArray();
            //define class
            return defineClass(name, buffer, 0, buffer.length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new ClassNotFoundException(name);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> clz = myClassLoader.loadClass("com.zhenbin.lzb.java.classloader.Systemd");

        //output is : com.zhenbin.lzb.java.classloader.MyClassLoader@28d93b30
        System.out.println(clz.getClassLoader());

        //不能直接new，因为它不在classpath里，而是自定义的classLoader自己去加载的
        Method method = clz.getMethod("print");
        method.invoke(clz.newInstance());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('a');
        stringBuilder.append("eabds");
        stringBuilder.append(2344);
        System.out.println(stringBuilder.toString());

    }
}
