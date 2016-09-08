package com.zhenbin.lzb.algorithm;

/**
 * Created by zhenbin.lzb on 2016/9/8.
 */
public class Heap<T extends Comparable<? super T>> {
    private T[] nodes;
    private int count;

    public Heap(T[] nodes) {
        this.nodes = nodes;
        count = nodes.length;
        build();
    }

    private void build() {
        for (int i = count / 2 - 1; i >= 0; i--) {
            adjustPosition(i);
        }
    }

    public T pop() {
        if (count <= 0) return null;
        T topNode = nodes[0];
        nodes[0] = nodes[--count];
        adjustPosition(0);
        return topNode;
    }

    private void adjustPosition(int position) {
        int currentPosition = position;
        int nextPostion = 2 * currentPosition + 1;
        while (nextPostion < count) {
            if (nextPostion + 1 < count && nodes[nextPostion + 1].compareTo(nodes[nextPostion]) < 0) {
                nextPostion++;
            }
            if (nodes[currentPosition].compareTo(nodes[nextPostion]) <= 0) {
                break;
            }
            T temp = nodes[currentPosition];
            nodes[currentPosition] = nodes[nextPostion];
            nodes[nextPostion] = temp;
            currentPosition = nextPostion;
            nextPostion = 2 * currentPosition + 1;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {8, 10, 32, 11, 32, 1, 7, 3, 5, 6, 9, 2, 100, 100, 100};
        //这里一定要写成”Heap<Integer> heap“，当我们不提供泛型类型时，会默认使用Object会代替
        Heap<Integer> heap = new Heap<Integer>(a);
        Integer leastNumber;
        while ((leastNumber = heap.pop()) != null) {
            System.out.print(" " + leastNumber);
        }
    }
}
