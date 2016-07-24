/**
  ____ _                 _            ____
 / ___| |__   __ _ _ __ | |_ ___ _ __| ___|
| |   | '_ \ / _` | '_ \| __/ _ \ '__|___ \
| |___| | | | (_| | |_) | ||  __/ |   ___) |
\____ |_| |_|\__,_| .__/ \__\___|_|  |____/
                  |_|
 */

//拡張関数を定義してみたお
operator fun String.times(i:Int): String {
    var str = this
    for (value in 0..i) {
        str += this
    }
    return str
}

fun String.divider() = println(this * 10)

//関数の定義
fun succ(i: Int): Int = i + 1

//引数の二乗を返す関数
fun square(i: Int): Int = i * i

//挨拶
fun hello(name: String): String = "ドーモ、${name} = サン"

//引数を2つ渡して大きい方を返す
fun max(a: Int, b: Int):Int = if(b <= a) a else b

//文を持った関数 = は不要だが、返り値の方は省略できない
fun sum(ints: Array<Int>): Int {
    var sum = 0
    for (i in ints) {
        sum += i
    }
    return sum
}

//名前付き引数とデフォルト引数
/**
 * @param minuend: 被減数
 * @param subtrahend: 減数
 */
fun sub(minuend: Int, subtrahend: Int):Int = minuend - subtrahend
fun defaultArgHello(name: String = "World"): String = "Hello ${name}"

//可変長引数
//varargに指定された型Intは特化された配列クラス(IntArray)とみなされる
//更に可変長引数は一つの関数に一つまでしか持てない
fun varargSum(vararg ints: Int): Int {
    var sum = 0
    for (i in ints) {
        sum += i
    }
    return sum
}

//再帰呼び出し最適化 tailrecを使う
tailrec fun recursiveSum(numbers: List<Long>, accumulator: Long = 0): Long =
    if (numbers.isEmpty()) accumulator
    else recursiveSum(numbers.drop(1), accumulator + numbers.first())

//ローカル関数
fun recursiveSum(numbers: List<Long>): Long {
    tailrec fun go(numbers: List<Long>, accumulator: Long): Long =
            if (numbers.isEmpty()) accumulator
            else go(numbers.drop(1), accumulator + numbers.first())
    return go(numbers, 0)
}

//何も結果をかえさない関数はUnitを返すってのは例を省略する

fun main(args: Array<String>) {
    val result = succ(30)
    println(result)
    println(hello("木吉"))
    println(max(12, 33))
    "-".divider()

    println(sum(arrayOf(1, 3, 4)))
    "-".divider()

//    名前が指定できるので引数の順番もこの通り
    println(sub(subtrahend =  28, minuend = 83))
//    デフォルト値がセットされているのでこの通り引数の省略もできる
    println(defaultArgHello())
    println("ああああ")
    "-".divider()

//    可変長引数の呼び出し。可変長引数として配列を渡すことを知らせるために*を付けてやる必要があるみたい
    println(varargSum(*intArrayOf(1, 3, 4)))
    "-".divider()

    println(recursiveSum((1L..12345).toList()))
}