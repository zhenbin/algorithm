package com.zhenbin.lzb.algorithm.sort;

/**
 * Created by zhenbin.lzb on 2016/9/9.
 */
public class Merge {
    private int outerI = 1;

    class InnerClass {
        public void message() {
            System.out.println("inner method!");
            outerI = 2;
            System.out.println(outerI);
        }
    }

    public InnerClass getInnerClass() {
        return new InnerClass();
    }

    public void doSomething() {
        class InnerClass2 {
            public void printOuterI() {
                outerI = 3;
                System.out.println(outerI);
            }
        }
        InnerClass2 innerClass2 = new InnerClass2();
        innerClass2.printOuterI();
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        merge.getInnerClass().message();
        merge.doSomething();
    }
}
