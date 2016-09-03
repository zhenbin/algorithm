import com.zhenbin.lzb.algorithm.Aho;
import org.junit.Test;

/**
 * Created by zhenbin.lzb on 2016/9/3.
 */
public class AhoTest extends BaseTest {
    @Test
    public void ahoTest() {
        Aho aho = new Aho();
        aho.insert("abcd");
        aho.insert("bcde");
        aho.insert("acc");
        aho.insert("defg");
        aho.insert("cdad");

        aho.build();
        aho.match("abcdefgabcabcde");

    }
}
