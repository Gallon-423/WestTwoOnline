package Java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        //以下创建一个客户表
        List<Customer> customers=new ArrayList<>();//空的顾客列表
        Customer[] cs=new Customer[100];
        cs[0]=new Customer("Tom",5,LocalDate.of(2021,10,30));
        cs[1]=new Customer("Sam",7,LocalDate.of(2021,10,30));
        cs[2]=new Customer("Mary",3,LocalDate.of(2021,10,31));
        cs[3]=new Customer("Gallon",1,LocalDate.of(2021,10,31));
        cs[4]=new Customer("Lucky",4,LocalDate.of(2021,12,5));
        cs[5]=new Customer("Jack",8,LocalDate.of(2021,12,6));
        cs[6]=new Customer("Jack",12,LocalDate.of(2021,12,6));
        cs[7]=new Customer("Kyle",6,LocalDate.of(2021,12,7));
        cs[8]=new Customer("Nancy",2,LocalDate.of(2021,12,7));
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

        //以下创建一个猫表
        OrangeCat c0=new OrangeCat("OO",5,true,true);
        OrangeCat c1=new OrangeCat("KK",4,false,true);
        BlackCat c2=new BlackCat("Joker",8,true);
        BlackCat c3=new BlackCat("Batman",3,false);
        List<Cat> cats=new ArrayList<>();
        cats.add(c0);
        cats.add(c1);
        cats.add(c2);
        cats.add(c3);
        BlackCat buyExample0=new BlackCat("Panda",4,true);
        OrangeCat buyExample1=new OrangeCat("Kitty",7,false,false);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//




        //以下创建一个MyCatCafe
        MyCatCafe myCatCafe=new MyCatCafe(cats,customers,2000);
        //测试purchase
        System.out.println("买入两只猫：");
        System.out.println("当前猫咖余额："+myCatCafe.getMoney());
        myCatCafe.purchase(buyExample0);
        System.out.println("买入一只橙猫");
        System.out.println("当前猫咖余额："+myCatCafe.getMoney());
        myCatCafe.purchase(buyExample1);
        System.out.println("买入一只黑猫");
        System.out.println("当前猫咖余额："+myCatCafe.getMoney());
        System.out.println("————————————————————————————————————————————————————————————————");
        //测试entertain
        System.out.println("招待9个客人:");
        System.out.println("当前猫咖余额："+myCatCafe.getMoney());
        for (int i = 0; i < 9; i++) {
            myCatCafe.entertain(cs[i]);
        }
        System.out.println("当前猫咖余额："+myCatCafe.getMoney());
        System.out.println("————————————————————————————————————————————————————————————————");
        //测试close
        System.out.println("店铺打烊清点：");
        myCatCafe.close();











//        LocalDate today=LocalDate.now();
//        System.out.println("The msg of today:"+today);
    }
}
