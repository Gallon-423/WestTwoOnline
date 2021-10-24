package Java;

/**
 * @Author ChenJialong
 * @Date 2021/10/5 19:07
 * @Description
 * 第一题（Java 基础语法）期末到了，你用 java 程序帮助老师统计学生们的成绩。
 *  * 要求：设计两个静态方法，
 *  * ·方法 1 统计学生们的平均成绩，接受一个学生成绩的(int[])整数数组 scores，返
 *  * 回平均分数(double)；
 *  * 示例：给定 scores = {59, 64, 86, 48, 76}，平均成绩 average = 66.6
 *  * ·方法 2 同样接受学生成绩的(int[])整数数组 scores，找出分数最高的同学，返回
 *  * 对应下标(int)。
 *  * 示例：给定 scores = {59, 64, 86, 48, 76}，返回分数最高同学(86)的下标:2
 *  * @Since version-1.0
 */
public class Scores {
    static public int indexOfMax(int[] scores){
        int max=-1;
        int index=-1;
        for (int i = 0; i < scores.length; i++) {
            if(scores[i]>max){
                max=scores[i];
                index=i;
            }

        }
        return index;
    }

    static public double average(int[] scores){
        double sum=0;
        for (int i = 0; i < scores.length; i++) {
            sum+=scores[i];
        }
        return sum/scores.length;
    }

}
