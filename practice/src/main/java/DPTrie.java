/**
 * Created by zhenbin.lzb on 2016/9/2.
 * UVALive 3942
 * http://blog.csdn.net/qian99/article/details/18730455
 */
public class DPTrie {

    public static void main(String[] args) {
        String[] dict = {"abc", "cde"};
        String words = "abcde";

        Trie trie = new Trie();
        for (String str : dict) {
            trie.insert(str);
        }

        int mathDictNum[] = new int[dict.length];   //dp


    }
}
