package Java_3;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("以下测试邮箱验证（正则）：");
        String[] mails=new String[5];
        mails[0]="hahaha@gmail.com";
        mails[1]="007008009@qq.com";
        mails[2]="4399.com";
        mails[3]="Hello world!";
        mails[4]="你好世界@egm.com.cn";
        Arrays.stream(mails).forEach(RegexUtil::judge);
        System.out.println("————————————————————————————————————————————————————————————————");
        System.out.println("以下测试线程互斥：");
        int[] a1={1,3,5};
        int[] a2={2,4,6};
        Mutex mutexUtil=new Mutex();
        Thread t1=new Thread(()->{
            try {
                mutexUtil.fun1(a1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        Thread t2=new Thread(()->{
            try {
                mutexUtil.fun2(a2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2");
        t1.start();
        t2.start();

    }
}
