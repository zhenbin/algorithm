import com.zhenbin.lzb.algorithm.KMP;
import org.junit.Test;

/**
 * Created by zhenbin.lzb on 2016/9/2.
 */
public class KMPTest extends BaseTest {
    @Test
    public void kmpTest() {
        KMP kmp = new KMP("abcdabe");
        System.out.println(kmp.matchString("abcde"));
        System.out.println(kmp.matchString("abcdabe"));
        System.out.println(kmp.matchString("dabcdabe"));
        System.out.println(kmp.matchString("abcdef"));
        System.out.println(kmp.matchString("abcdf"));
    }
}
