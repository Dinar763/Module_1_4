package homeWork.var2Semaphore;

import java.util.concurrent.Semaphore;

public class Foo2 {
    private final Semaphore sem1 = new Semaphore(0);
    private final Semaphore sem2 = new Semaphore(0);

    public void first() {
        print("first");
        sem1.release();
    }

    public void second() throws InterruptedException {
        sem1.acquire();
        print("second");
        sem2.release();
    }

    public void third() throws InterruptedException {
        sem2.acquire();
        print("third");
    }

    private void print(String message) {
        System.out.print(message);
    }
}
