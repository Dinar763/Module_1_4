package homeWork.var2Semaphore;

public class MainApp2 {
    public static void main(String[] args) {
        Foo2 foo2 = new Foo2();

        Thread threadA = new Thread(() -> foo2.first());
        Thread threadB = new Thread(() -> {
            try {
                foo2.second();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadC = new Thread(() -> {
            try {
                foo2.third();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadC.start();
        threadB.start();
        threadA.start();
    }
}
