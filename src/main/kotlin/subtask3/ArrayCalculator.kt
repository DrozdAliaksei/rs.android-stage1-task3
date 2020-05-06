package subtask3

import kotlin.math.absoluteValue

class ArrayCalculator {
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val numbers =
            itemsFromArray.filterIsInstance<Int>().sortedBy { it.absoluteValue }
        if (numbers.isEmpty()) return 0
        val items = if (numberOfItems > numbers.size) numbers.size else numberOfItems
        if (negativeNumbers(numbers) / 2 > 0) {
            val absSorted = multiplication(numbers.takeLast(items))
            val positiveSort = multiplication(numbers.sorted().takeLast(items))
            return if (absSorted > positiveSort) absSorted else positiveSort
        }

        return multiplication(numbers.sorted().takeLast(items))
    }
}

private fun multiplication(arr: List<Int>): Int {
    var result = 1
    arr.forEach { result *= it }
    return result
}

private fun negativeNumbers(arr: List<Int>): Int {
    var negativeCount = 0
    arr.forEach { if (it < 0) negativeCount++ }
    return negativeCount
}
