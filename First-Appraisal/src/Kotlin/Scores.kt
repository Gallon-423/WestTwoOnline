package Kotlin
fun main(){
    //该文件本身既是实现又是测试类。
    var arr= listOf<Int>(59, 64, 86, 48, 76);
    println("平均成绩为"+average(arr));
    println("最高成绩所在下标为"+ maxIndex(arr));

}
fun average(arr: List<Int>):Double{
    var sum=0;
    for(num in arr){
        sum+=num;
    }
    var len:Double=arr.size*1.0;
    return sum/len;

}
fun maxIndex(arr: List<Int>):Int{
    var max=-1;
    var maxIndex=-1;
    for(i in 0..arr.size-1){
        if(arr[i]>max){
            max=arr[i]
            maxIndex=i
        }
    }
    return maxIndex;

}