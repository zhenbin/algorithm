package com.zhenbin.lzb.java.io.serialize;

import java.io.*;

/**
 * Created by melon on 16/9/30.
 */
public class SeriDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee tom = new Employee("tom");
        Employee mary = new Employee("mary");
        mary.setBoss(tom);

        //write to local storage
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/employee.out"));
        out.writeObject(tom);
        out.writeObject(mary);

        //read from local storage
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data/employee.out"));
        Employee newTom = (Employee)in.readObject();
        Employee newMary = (Employee)in.readObject();

        System.out.println(newTom == newMary.getBoss());
    }
}
