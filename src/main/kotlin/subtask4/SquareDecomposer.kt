package subtask4

import kotlin.math.sqrt

class SquareDecomposer {
    fun decomposeNumber(number: Int): Array<Int>? {
        return if (number < 3) null
        else finder(square(number), number - 1)?.toTypedArray()
    }

    private fun finder(number: Int, position: Int): ArrayList<Int>? {
        for (i in position downTo 1) {
            val rest = squareDiff(number,i)
            if (rest == 0) return arrayListOf(i)
            if (rest < 0) return null
            var radical = sqrt(rest.toDouble()).toInt()
            if (radical >= i) radical = i - 1
            val result = finder(rest, radical)
            if (result != null) {
                result.add(i)
                return result
            }
        }
        return null
    }

    private fun square(x: Int) = x * x
    private fun squareDiff(a: Int, b: Int) = a - square(b)
}
