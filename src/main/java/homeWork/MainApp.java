package homeWork;

public class MainApp {
    public static void main(String[] args) {
        Foo foo = new Foo();

        Runnable runA = () -> foo.first();
        Runnable runB = () -> {
            try {
                foo.second();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable runC = () -> {
            try {
                foo.third();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread threadC = new Thread(runC, "ThreadC");
        Thread threadB = new Thread(runB, "ThreadB");
        Thread threadA = new Thread(runA, "ThreadA");

        threadC.start();
        threadB.start();
        threadA.start();

        try {
            threadC.join();
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
