package subtask1

class PolynomialConverter {
    fun convertToStringFrom(numbers: Array<Int>): String? {
        var result = ""
        if (numbers.isEmpty()) return null
        else {
            for (i in numbers.indices) {
                if (i == 0 && numbers[i] > 0) result += "${numbers[i]}x^${numbers.size - i - 1} "
                else if (i == 0 && numbers[i] < 0) result += "${numbers[i]}x^${numbers.size - i - 1} "
                else if (i < numbers.size - 1) {
                    if (numbers[i] > 0 && i < numbers.size - 2) result += "+ ${numbers[i]}x^${numbers.size - i - 1} "
                    else if (numbers[i] < 0 && i < numbers.size - 2) result += "- ${numbers[i] * -1}x^${numbers.size - i - 1} "
                    else if (numbers[i] > 0) result += "+ ${numbers[i]}x "
                    else if (numbers[i] < 0) result += "- x "
                } else if (numbers[i] != 0) {
                    result += if (numbers[i] > 0) "+ ${numbers[i]}"
                    else "- ${numbers[i]}"
                }
            }
        }
        return result
    }
}
