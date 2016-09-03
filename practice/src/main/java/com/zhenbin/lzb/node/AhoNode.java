package com.zhenbin.lzb.node;

/**
 * Created by zhenbin.lzb on 2016/9/3.
 */
public class AhoNode {

    public boolean isEnd;
    public AhoNode[] next;
    public AhoNode gotoNext;
    public Object otherValues;
    public final static int NEXT_COUNT = 4;      //26¸öÐ¡Ð´×ÖÄ¸

    public AhoNode() {
        isEnd = false;
        next = new AhoNode[NEXT_COUNT];
    }
}