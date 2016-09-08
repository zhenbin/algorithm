import com.zhenbin.lzb.apply.DPAho;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhenbin.lzb on 2016/9/7.
 */
public class HelloTest extends DPAho implements Runnable {
    public static void main(String[] args) {
        Integer[] numbers2 = {2, 5, 3, 4, 4, 8, 7, 5};
        List<Integer> numbers = Arrays.asList(numbers2);
        Collections.sort(numbers);
        for (Integer number : numbers) {
            System.out.print(" " + number);
        }

    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {

    }
}
