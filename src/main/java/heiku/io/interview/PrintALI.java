package heiku.io.interview;

/**
 * 三线程轮流打印 ALI，循环 10 次
 *
 * @Author: Heiku
 * @Date: 2020/1/16
 */
public class PrintALI {

    public static Object object = new Object();
    public static int state = 0;
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new PrintThread(i).start();
        }
    }

    static class PrintThread extends Thread{
        int n;
        PrintThread(int n){
            this.n = n;
        }
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (object){
                    while (state % 3 != n){
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    print(n);
                    state++;
                    object.notifyAll();
                }
            }
        }

        private void print(int n) {
            if (n == 0){
                System.out.println(Thread.currentThread().getName() + " print: A");
            }else if (n == 1){
                System.out.println(Thread.currentThread().getName() + " print: L");
            }else{
                System.out.println(Thread.currentThread().getName() + " print: I");
            }
        }
    }
}
