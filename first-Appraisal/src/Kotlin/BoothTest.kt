package Kotlin

import java.util.*

fun main() {
    println("------------------------------")
    println("以下测试初始化（以及验证ID的唯一性，将boothe2的初始化改为行注释中的即可）：")
    var booth1 = Booth_Kotlin(12345, "哥俩儿", 15, false);
    println("当前已注册摊贩数量为：" + Booth_Kotlin.count)

    //var booth2=Booth_Kotlin(12345,"哥们",27,true);
    //println(Booth_Kotlin.count)
    //以上变量的实例化过程将会报错，因为ID重复，为自定义错误。

    var booth2 = Booth_Kotlin(12346, "异形", 27, true);
    println("当前已注册摊贩数量为：" + Booth_Kotlin.count)

    var booth3 = Booth_Kotlin(14666, "西瓜太郎", 108, true);
    println("当前已注册摊贩数量为：" + Booth_Kotlin.count)

    var booth4 = Booth_Kotlin(18888, "偷瓜的猹", 66, true);
    println("当前已注册摊贩数量为：" + Booth_Kotlin.count)

    //你可以通过控制台自己创建一个实例
    println("请输入ID号：")
    val sc = Scanner(System.`in`);

    val para1 = sc.nextLong();
    if (para1 in idList) {
        throw Exception("ID已存在！")
    }
    println("请输入商家名：")
    val para2 = sc.next();
    println("请输入当前西瓜数量：")
    val para3 = sc.nextInt();
    println("请输入当前是否休摊：Y/N")
    val sc4 = sc.next();
    val sc4_0 = sc4?.toCharArray();
    val para4 = sc4_0?.get(0)?.equals('Y')!!
    val myBooth:Booth_Kotlin= Booth_Kotlin(para1,para2,para3,para4);
    println(myBooth)



    println("------------------------------")
    println("以下测试重载的tostring()方法：")
    println(booth1)
    println(booth2)
    println("------------------------------")
    println("以下测试purchase()方法：")
    Booth_Kotlin.purchase(booth1, 5)
    Booth_Kotlin.purchase(booth2, 5);
    println(booth1)
    println(booth2)
    println("------------------------------")
    println("以下测试closeBooths()方法：")
    var booths = listOf<Booth_Kotlin>(booth1, booth2, booth3, booth4);
    Booth_Kotlin.closeBooths(booths);
    println("------------------------------")
    println("以下测试restock()方法：")
    booth1.restock(201);
    println("进货前：" + booth1)
    booth1.restock(50);
    println("进货后：" + booth1)

}