package com.example.motionlayoutproject.other
// ② 当类名过长时，可以通过import alias 进行简化(实际并没啥卵用)--但是该方法更逗的是使用在2个同名的类名同时使用的情况下
import com.example.motionlayoutproject.other.LongLongLongLongLongEntity as longClass
/**
 * ①
 * 优点：可以简化长的代码
 * 缺点：如果带参数，则在使用的时候不易看到参数的提示
 * 其他：别名并没引入新的类型这个和inline class是不一样的
 */
typealias BlockWithEmpty = ()->Unit
fun test(blockWithEmpty: BlockWithEmpty){

}

