import org.junit.After;
import org.junit.Before;

/**
 * Created by zhenbin.lzb on 2016/9/3.
 */
public class BaseTest {
    long timeStart, timeEnd;

    @Before
    public void timeBefore() {
        timeStart = System.currentTimeMillis();
    }

    @After
    public void timeAfter() {
        timeEnd = System.currentTimeMillis();
        System.out.println("\ntime cost : " + (timeEnd - timeStart) + " ms.");
    }
}
