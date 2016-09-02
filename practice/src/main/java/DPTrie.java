import java.util.List;

/**
 * Created by zhenbin.lzb on 2016/9/2.
 * UVALive 3942
 * http://blog.csdn.net/qian99/article/details/18730455
 */
public class DPTrie {

    public static void main(String[] args) {
        String[] dict = {"abc", "cde", "abcf"};
        String words = "aadabcfdafabcde";

        Trie trie = new Trie();
        for (String str : dict) {
            trie.insert(str);
        }

        int matchDictNum[] = new int[words.length() + 1];   //dp
        matchDictNum[words.length()] = 0;

        for (int i = words.length() - 1; i >= 0; i--) {
            String subString = words.substring(i);
            List<Integer> matchNums = trie.match(subString);
            int maxMatch = matchDictNum[i + 1];
            for (Integer matchNum : matchNums) {
                if (maxMatch < matchNum + matchDictNum[i + matchNum]) {
                    maxMatch = matchNum + matchDictNum[i + matchNum];
                }
            }
            matchDictNum[i] = maxMatch;
        }

        System.out.println("max match is " + matchDictNum[0]);
    }
}
