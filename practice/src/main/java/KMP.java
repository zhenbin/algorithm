/**
 * Created by zhenbin.lzb on 2016/9/2.
 */
public class KMP {
    private char[] matchingStr;
    private int[] next;

    public KMP(String matchingString) {
        matchingStr = matchingString.toCharArray();
        next = new int[matchingString.length()];
        initNext();
    }

    //����next����
    private void initNext() {
        next[0] = 0;
        for (int i = 1; i < matchingStr.length; i++) {
            int point = next[i - 1];
            while (point > 0 && matchingStr[point] != matchingStr[i]) {
                point = next[point];
            }
            next[i] = matchingStr[point] == matchingStr[i] ? point + 1 : 0;
        }
    }

    /**
     * ��targetString����ƥ�䣬����ƥ����ʱ��targetString��ͷ���±�
     * ��δƥ�䷵��-1
     */
    public int matchString(String targetString) {
        char[] targetStr = targetString.toCharArray();
        int matchingStrPoint = 0;
        for (int i = 0; i < targetStr.length; i++) {
            while (matchingStrPoint > 0 && matchingStr[matchingStrPoint] != targetStr[i]) {
                matchingStrPoint = next[matchingStrPoint];
            }
            matchingStrPoint = matchingStr[matchingStrPoint] == targetStr[i] ? matchingStrPoint + 1 : 0;
            if (matchingStrPoint == matchingStr.length)
                return i + 1 - matchingStr.length;
        }
        return -1;
    }
}
