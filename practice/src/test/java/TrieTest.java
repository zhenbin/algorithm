import org.junit.Test;

/**
 * Created by zhenbin.lzb on 2016/9/2.
 */
public class TrieTest {

    @Test
    public void insertTest() {
        Trie trie = new Trie();
        trie.insert("abcdes");
        trie.insert("abesgc");
        trie.insert("abesgc");
        trie.insert("c");
        trie.insert("desg");

        trie.printTrie();
    }
}
