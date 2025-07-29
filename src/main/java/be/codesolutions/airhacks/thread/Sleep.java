package be.codesolutions.airhacks.thread;

import be.codesolutions.airhacks.zcl.Log;

import java.time.Instant;
import java.util.concurrent.locks.LockSupport;

public class Sleep {

    public static final int SLEEP_TIME_MILIS = 1000;

    public static void main(String[] args) {
        sleep1();
        sleep2();
        sleep3();
    }

    private static void sleep1() {
        Log.INFO.out("Sleep method 1");
        System.out.println(Instant.now().toString());

        try {
            Thread.sleep(SLEEP_TIME_MILIS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Instant.now().toString());
    }

    private static void sleep2() {
        Log.INFO.out("Sleep method 2");
        System.out.println(Instant.now().toString());

        try {
            Thread.currentThread().join(SLEEP_TIME_MILIS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Instant.now().toString());
    }

    private static void sleep3() {
        Log.INFO.out("Sleep method 3");
        System.out.println(Instant.now().toString());

        LockSupport.parkNanos(SLEEP_TIME_MILIS * 1000 * 1000);

        System.out.println(Instant.now().toString());
    }
}
