package subtask2

class Combinator {
    fun checkChooseFromArray(array: Array<Int>): Int? {
        val m = array[0]
        val n = array[1]
        for (i in 0..n) {
            if (calculateFactorial(n) == m * calculateFactorial(n - i) * calculateFactorial(i)) {
                return  i
            }
        }
        return null
    }

    private fun calculateFactorial(x: Int): Int {
        var result = 1
        for (i in 1..x) {
            result *= i
        }
        return result
    }
}
