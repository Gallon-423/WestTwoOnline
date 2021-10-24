package Kotlin
/**
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
//var pusta: List<Long> = emptyList()
var idList: MutableList<Long> = ArrayList()//pusta.toMutableList()

class Booth_Kotlin(var id:Long,var name:String,var total: Int,var isClosed:Boolean){
    init {
        count++;
        if(id in idList){
            throw Exception("错误！ID已存在！")
        }
        idList.add(id)
    }

    companion object{
        var count=0;
        fun  purchase(booth:Booth_Kotlin,num:Int){
            if(num>booth.total){
                println("购买失败，购买数量过大");
                return;
            }
            if (num<=0){
                println("购买失败，购买数量必须为正数");
                return;
            }
            if (booth.isClosed){
                println("购买失败，该摊位处于休摊状态");
                return;
            }
            println("购买成功");
            booth.total-=num;
            return;
        }

        fun closeBooths(list: List<Booth_Kotlin>){
            for (booth in list){
                if (booth.isClosed){
                    println(booth)
                }else{
                    booth.isClosed=false
                }
            }
        }
    }
    //返回类型为Boolean,若为true则说明进货成功，反之进货失败。
    fun restock(num: Int):Boolean{
        if (num>200){
            println("进货失败，进货数量不得超过200")
            return false
        }
        if(num<0){
            println("进货失败，进货数量不得为负数")
            return false
        }
        println("进货成功")
        this.total+=num;
        return true;
    }
    override fun toString(): String {
        val str=if(isClosed) "已休摊" else "未休摊"
        return "瓜摊号："+id+",商家名：'"+name+"',剩余瓜数："+total+",休摊状态："+str;
    }
}
