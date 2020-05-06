package subtask6

class FullBinaryTrees {
    private val binaryTrees = arrayListOf<String>()

    fun stringForNodeCount(count: Int): String {
        if (count % 2 == 0) return "[]"
        if (count == 1) return "[[0]]"
        val startTree = "000"
        val rest = count - 3
        val position = 1
        findBinaryTrees(rest, position, startTree)
        return binaryTrees.joinToString(",", "[", "]")
    }

    private fun findBinaryTrees(
        rest: Int,
        position: Int,
        tree: String
    ) {
        val nodes = "00"
        val nulls = "11"
        if (rest == 0) {
            binaryTrees.add(tree.chunked(1).joinToString(",", "[", "]").replace("1", "null"))
        } else {
            if (tree[position] == '0') {
                findBinaryTrees(rest - 2, position + 1, tree + nodes)
                findBinaryTrees(rest, position + 1, tree + nulls)
            } else if (tree[position] == '1') {
                val positionOfNextNode = tree.indexOf('0', position + 1)
                if (positionOfNextNode != -1) {
                    findBinaryTrees(rest, positionOfNextNode, tree)
                }
            }
        }
    }
}

