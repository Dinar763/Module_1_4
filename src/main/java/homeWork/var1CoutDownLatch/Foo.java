package homeWork.var1CoutDownLatch;

import java.util.concurrent.CountDownLatch;

public class Foo {
    private final CountDownLatch latch1 = new CountDownLatch(1);
    private final CountDownLatch latch2 = new CountDownLatch(1);

    public void first() {
        print("first");
        latch1.countDown();
    }
    
    public void second() throws InterruptedException {
        latch1.await();
        print("second");
        latch2.countDown();
    }

    private void print(String message) {
        System.out.print(message);
    }

    public void third() throws InterruptedException {
        latch2.await();
        print("third"); 
    }
}
