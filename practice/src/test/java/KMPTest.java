import org.junit.Test;

/**
 * Created by zhenbin.lzb on 2016/9/2.
 */
public class KMPTest {
    @Test
    public void kmpTest() {
        KMP kmp = new KMP("abcde");
        System.out.println(kmp.matchString("abcde"));
        System.out.println(kmp.matchString("aabcde"));
        System.out.println(kmp.matchString("abcdef"));
        System.out.println(kmp.matchString("abcdf"));
    }
}
