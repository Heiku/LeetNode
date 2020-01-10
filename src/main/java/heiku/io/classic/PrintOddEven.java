package heiku.io.classic;

/**
 * @Author: Heiku
 * @Date: 2020/1/10
 */
public class PrintOddEven {

    public final Object monitor = new Object();
    private int i;

    public void printOddEven(int num){
        Thread odd = new Thread(new Print(num));
        odd.setName("thread-A");

        Thread even = new Thread(new Print(num));
        even.setName("thread-B");

        odd.start();
        even.start();
    }

    class Print implements Runnable{
        int num;

        Print(int num){
            this.num = num;
        }

        @Override
        public void run() {
            try {
                while (i < num){
                    synchronized (monitor){
                        System.out.println(Thread.currentThread().getName() + " : " + i++);

                        // first notify another thread, then block self(waiting another notify)
                        monitor.notify();
                        monitor.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new PrintOddEven().printOddEven(100);
    }
}
