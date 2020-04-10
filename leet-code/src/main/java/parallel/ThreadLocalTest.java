package parallel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThreadLocalTest {

    public static final ThreadLocal<SimpleDateFormat> simpleDateFormat = new ThreadLocal<SimpleDateFormat>() {
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public void printDate() {
        List<NewDate> hehe = new ArrayList<NewDate>() {
            {
                add(new NewDate());
                add(new NewDate());
                add(new NewDate());
                add(new NewDate());
                add(new NewDate());
                add(new NewDate());
                add(new NewDate());
                add(new NewDate());
                add(new NewDate());
                add(new NewDate());
                add(new NewDate());

                add(new NewDate());
                add(new NewDate());
            }

        };
        for (NewDate newDate : hehe) {
            newDate.start();
        }
    }

    private class NewDate extends Thread {
        public void run() {
            String dateStr = simpleDateFormat.get().format(new Date());
            System.out.println(dateStr);
        }
    }
}
