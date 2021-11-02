package Java_3;

public class Mutex {

    private volatile boolean flag;

    public Mutex() {
    }
    /*
     * @Author ChenJialong
     * @Date 2021/8/5 21:08
     * @Description 对方法进行synchronized化，同时通过设置的标志量flag保持输出顺序。
     * @Since version-1.0
     */
    public synchronized void fun1(int[] a1) throws InterruptedException {
        for (int i = 0; i < a1.length; i++) {
            if (flag) {
                this.wait();
            }
            System.out.print(a1[i]+" ");
            flag = !flag;
            this.notifyAll();
        }
    }

    public synchronized void fun2(int[] a2) throws InterruptedException {
        for (int i = 0; i < a2.length; i++) {
            if (!flag) {
                this.wait();
            }
            System.out.print(a2[i]+" ");
            flag = !flag;
            this.notifyAll();
        }
    }
}
