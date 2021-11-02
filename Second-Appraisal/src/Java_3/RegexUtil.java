package Java_3;

public class RegexUtil {
    static String regex_en="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    //不允许邮箱名出现中文。
    static String regex_cn="^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    //允许邮箱名出现中文。
    static boolean judge(String mailPath){
        if(mailPath.matches(regex_en)){
            System.out.println(mailPath+" 为合法邮箱");
            return true;
        }else if(mailPath.matches(regex_cn)){
            System.out.println("邮箱名可含有中文情况下，"+mailPath+" 为合法邮箱,否则不是。");
            return true;
        }
        System.out.println(mailPath+" 不是合法邮箱");
        return false;
    }
}
