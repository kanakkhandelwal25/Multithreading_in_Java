package Examples;

class MyThread implements Runnable {
    String thrdName;

    MyThread(String name) {
        thrdName = name;
    }

    @Override
    public void run() {
        System.out.println(thrdName + "starting.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + thrdName + ", count is " + count);
            }
        } catch (InterruptedException exc) {
            System.out.println(thrdName + "interrupted.");
        }
        System.out.println(thrdName + " terminating.");
    }
}

public class UseThreads {
    public static void main(String[] args) {
        System.out.println("Main thread starting.");

        MyThread obj = new MyThread("Child #1");

        Thread newThrd = new Thread(obj);

        newThrd.start();

        for (int index = 0; index < 50; index++) {
            System.out.println(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        }

        System.out.println("Main thread ending.");

    }
}
