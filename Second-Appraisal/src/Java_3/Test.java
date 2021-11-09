package Java_3;

import java.util.Arrays;
/**
 * @Author Gallon
 * @ClassName Test
 * @Package Java_3
 * @Description  测试类
 * @Time 2021-11-09,周二 11:27
 */

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
        //该实现方法必须保证 a1、a2整型数组长度相同
        SynchronizedImpl myMutex= new SynchronizedImpl();
        //可以修改下方两个数组的值
        int[] a1= {1,3,5,7,9};
        int[] a2= {2,4,6,8,10};
        //实现的void方法，传入两个数组
        myMutex.mutex(a1,a2);
    }
}
