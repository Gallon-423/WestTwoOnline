package Java;

/**
 * @Author ChenJialong
 * @Date 2021/10/5 18:11
 * @Description
 * 第一题（Java 基础语法）期末到了，你用 java 程序帮助老师统计学生们的成绩。
 * 第二题 (面向对象)设计一个西瓜摊 Java.Booth 类：
 */
public class Test {
    public static void main(String[] args) throws Exception {
        int[] example1={59, 64, 86, 48, 76};
        System.out.println("最高成绩所在下标为 "+Scores.indexOfMax(example1));
        System.out.println("平均成绩为 "+Scores.average(example1));
        //以上测试第一题
        Booth booth=new Booth(123456,"哥俩",20,false);
        //Booth booth1=new Booth(123456,"哥们儿",15,true);将会throw出ID重复的Exception
        Booth booth1=new Booth(123455,"哥们儿",15,true);
        boolean buySuccessful= Booth.purchase(booth,25);
        buySuccessful= Booth.purchase(booth,-1);
        buySuccessful= Booth.purchase(booth1,2);
        booth.restock(201);
        booth.restock(30);
        Booth[] booths=new Booth[2];
        booths[0]=booth;
        booths[1]=booth1;
        Booth.closeBooths(booths);
        //以上测试第二题
    }

}
