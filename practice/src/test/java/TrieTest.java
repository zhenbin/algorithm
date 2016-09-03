import com.zhenbin.lzb.algorithm.Trie;
import org.junit.Test;

/**
 * Created by zhenbin.lzb on 2016/9/2.
 */
public class TrieTest extends BaseTest {

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
