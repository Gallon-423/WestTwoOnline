fun main() {
    //类型后面加?表示可为空
    val age: String? = null

    //抛出空指针异常
    //val ages = age!!.toInt()

    //不做处理返回 null
    val ages1 = age?.toInt()
    println(ages1)

    //age为空返回-1
    val ages2 = age?.toInt() ?: -1
    println(ages2)

    for (i in 1..4) print("$i ") // 输出“1234”
    println("")
    for (i in 4..1) print("$i ") // 什么都不输出
    println("")
    // 使用 step 指定步长
    for (i in 1..4 step 2) print("$i ") // 输出“13”
    println("")
    for (i in 6 downTo 2 step 2) print("$i ") // 输出“42”
    println("")

    // 使用 until 函数排除结束元素
    for (i in 1 until 10) {   // i in [1, 10) 排除了 10
        print("$i ")
    }
    println("")//Nothing...
}