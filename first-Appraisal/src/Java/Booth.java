package Java;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ChenJialong
 * @Date 2021/10/5 18:27
 * @Description (面向对象)设计一个西瓜摊 Java.Booth 类：
 * 私有变量：
 * 摊号 long id，摊主姓名 String name，在售西瓜数 int total，是否休摊整改
 * boolean isClosed
 * 方法：
 * 1）上述变量对应的 get 和 set 方法，以及一个重写的 toString()方法来输出
 * 该西瓜摊的所有信息（要有一定的格式）；
 * 2）一个接受摊号(long)、摊主姓名(name) 、在售西瓜数(int)、是否休摊整改
 * (boolean)作为参数的构造方法。
 * 3）一个静态(static)方法 purchase（Java.Booth 商家, int 购买数量）, 向目标摊位卖家
 *  * 购买指定数量的西瓜。
 * 购买的西瓜数必须为正数；商家不能处于休摊整改状态；购买西瓜数不能大于在售西
 * 瓜数。出现以上情况视为购买失败，摊主在售西瓜数不能有所变化。
 * 无论交易成功与否，都要输出一定的提示信息。
 * 4）一个实例方法 restock(int 进货西瓜数),为对应摊位进货，单次进货量不能超过
 * 200，进货失败则输出相应的提示信息。
 * 5）一个静态(static)方法 closeBooths（Java.Booth[] booths）让 booths 中所有未被休
 * 业整改的摊位歇业(将 false 变为 true)，输出已在休业整改的摊位信息（调用实例的
 * toString()方法）
 */
public class Booth {
    private long id;
    private String name;
    private int total;
    private boolean isClosed;
    static ArrayList<Long> idList=new ArrayList<>();

    public Booth(long id, String name, int total, boolean isClosed) throws Exception {
        if(idList.contains(new Long(id))){
            throw new Exception("该ID已存在，请更换ID");
        }
        idList.add(id);
        this.id = id;
        this.name = name;
        this.total = total;
        this.isClosed = isClosed;
    }
    public Booth(){

    }
    /**
     * 向目标摊位卖家购买指定数量的西瓜。
     * @Param Java.Booth booth
     * @Param int num
     * @Return boolean 购买成功则返回true,否则返回false
     * @description
     * 购买的西瓜数必须为正数；商家不能处于休摊整改状态；购买西瓜数不能大于在售西
     * 瓜数。出现以上情况视为购买失败，摊主在售西瓜数不能有所变化。无论交易成功与否，都要输出一定的提示信息。
     */
    static boolean purchase(Booth booth, int num){
        if(booth.isClosed()){
            System.out.println("你是故意找岔儿是不是? ——当前该商家处于休摊整改状态，不得买瓜，请更换商家");
            return false;
        }
        if(num<=0){
            System.out.println("你要不要吧！ ——购买数量必须大于零，请修改购买数量");
            return false;
        }
        if (num>booth.getTotal()){
            System.out.println("都是大棚里的瓜~ --购买数量过多，请减少数量或更换商家");
            return false;
        }
        booth.setTotal(booth.getTotal()-num);
        System.out.println("买瓜成功！");
        return true;

    }
    /**
     * 进货（restock）
     * @Param int input
     * @Return boolean 进货成功则返回true
     * 一个实例方法 restock(int 进货西瓜数),为对应摊位进货，单次进货量不能超过200，进货失败则输出相应的提示信息。
     */
    public boolean restock(int num){
        if(num>200){
            System.out.println("进货数量过大，进货失败，请修改进货数量");
            return false;
        }
        this.setTotal(this.getTotal()+num);
        return true;
    }

    /**
     * closeBooths（Java.Booth[] booths）
     * @Param Java.Booth[] booth
     * @Return void
     * 让 booths 中所有未被休业整改的摊位歇业
     * (将 false 变为 true)，输出已在休业整改的摊位信息（调用实例的toString()方法）
     */
    static public void closeBooths(Booth[] booths){
        for (Booth booth:booths
             ) {
            if(booth.isClosed()){
                System.out.println(booth);
            }else{
                booth.setClosed(true);
            }

        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    @Override
    public String toString() {
        String close=isClosed?"已休摊":"未休摊";
        return "瓜摊" +
                "id=" + id +
                ", 商家名字为'" + name +"'"+
                ", 剩余瓜数:" + total +
                ", 休摊状态：" + close;
    }
}
