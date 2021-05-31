import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.system.*
import kotlin.random.Random

fun getMaxPairwiseProduct_solution1(numbers: IntArray): Long {
    var result = 0L
    val n = numbers.size
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (numbers[i] * numbers[j] > result) {
                result = numbers[i].toLong() * numbers[j].toLong()
            }
        }
    }
//    println("result 1: ".plus(result))
    return result
}

fun getMaxPairwiseProduct_solution2(numbers:IntArray): Long {
    val n = numbers.size
    if (n == 0) return 0L
    else if (n == 1) return numbers[0].toLong()
    else if (n == 2) return numbers[0].toLong() * numbers[1].toLong()
    else {
        var max1Index = -1
        var max = -1
        for(i in 0 until n) {
            if (numbers[i] >= max) {
                max = numbers[i]
                max1Index = i
            }
        }

        max = -1
        var max2Index = -1
        for(i in 0 until n) {
            if (numbers[i] > max && i != max1Index) {
                max = numbers[i]
                max2Index = i
            }
        }

        return numbers[max1Index].toLong() * numbers[max2Index].toLong()
    }
}

fun getMaxPairwiseProduct_solution3(numbers: IntArray): Long {
    val n = numbers.size
    var longNumbers = numbers.map{ it.toLong() }.sortedDescending()

    var result = 0L
    if (n >= 2) result = longNumbers[0] * longNumbers[1]
//    println("result 3: ".plus(result))
    return result
}

fun main(args: Array<String>) {
// stress test implementation
//    while(true) {
//        var n = Random.nextInt(0, 10) + 2
//        println(n)
//        val numbers = IntArray(n) { Random.nextInt(0, 1000000) }
//        println (Arrays.toString(numbers))
//
//        var result1 = 0L;
//        var result2 = 0L; var result3 = 0L
//        val timeInNanos1 = measureNanoTime {
//            result1 = getMaxPairwiseProduct_solution1(numbers)
//        }
//
//        val timeInNanos2 = measureNanoTime {
//            result2 = getMaxPairwiseProduct_solution2(numbers)
//        }
//
//        val timeInNanos3 = measureNanoTime {
//            result3 = getMaxPairwiseProduct_solution3(numbers)
//        }
//        println("Solution #1 took : ".plus(timeInNanos1))
//        println("Solution #2 took : ".plus(timeInNanos2))
//        println("Solution #3 took : ".plus(timeInNanos3))
//
//        if (!(result1 == result2 && result1 == result3 && result2 == result3)) break
//        println("result 2: ".plus(result2))
//        println("result 3: ".plus(result3))
//        if (result2 != result3) break
//    }

    val scanner = FastScanner(System.`in`)
    val n = scanner.nextInt()
    val numbers = IntArray(n)
    for (i in 0 until n) {
        numbers[i] = scanner.nextInt()
    }
    println(getMaxPairwiseProduct_solution2(numbers))

}

class FastScanner(stream: InputStream) {
    var br: BufferedReader = BufferedReader(InputStreamReader(stream))
    var st: StringTokenizer? = null

    fun next(): String {
        while (st == null || !st!!.hasMoreTokens()) {
            try {
                st = StringTokenizer(br.readLine())
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return st!!.nextToken()
    }

    fun nextInt() = next().toInt()
}
