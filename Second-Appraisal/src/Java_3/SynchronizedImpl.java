package Java_3;

/**
 * @Author Gallon
 * @ClassName SynchronizedImpl
 * @Package Java_3
 * @Description  利用synchronized信号量实现进程同步，交替打印
 * @Time 2021-11-09,周二 11:24
 */

public class SynchronizedImpl {



    private volatile boolean flag;

    public SynchronizedImpl() {

    }

    private synchronized void fun1(int[] array1) throws InterruptedException {
        /**
         * @Name fun1
         * @Params [array1]
         * @Types  [int[]]
         * @Return void
        */
        for (int i = 0; i < array1.length; i++) {
            if (flag) {
                this.wait();
            }
            System.out.print(array1[i]+" ");
            flag = !flag;
            this.notifyAll();

        }
    }

    private synchronized void fun2(int[] array2) throws InterruptedException {
        /**
         * @Name fun2
         * @Params [array2]
         * @Types  [int[]]
         * @Return void
        */
        for (int i = 0; i < array2.length; i++) {
            if (!flag) {
                this.wait();
            }
            System.out.print(array2[i]+" ");
            flag = !flag;
            this.notifyAll();

        }
    }

    public void mutex(int[] a1,int[] a2){
        /**
         * @Name mutex
         * @Params [a1, a2]
         * @Types  [int[], int[]]
         * @Description 新建线程并调用f1,f2两个方法，实现交替输出。
         * @Return void
        */
        Thread t1 = new Thread(()->{
            try {
                this.fun1(a1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");

        Thread t2 = new Thread(()->{
            try {
                this.fun2(a2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2");
        t1.start();
        t2.start();


    }

}
