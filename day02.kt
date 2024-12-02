fun main(){
    val data = File("day02.txt").readLines().map { it.split(" ").map(String::toInt) }
    var s = data.count { isSafe(it) }
    val safeCount = data.count { isSafeWithDampener(it) }
    println(s)
    println(safeCount)
}

fun isSafe(report: List<Int>): Boolean {
    val differences = report.zipWithNext { a, b -> b - a }
    val allIncreasing = differences.all { it in 1..3 }
    val allDecreasing = differences.all { it in -3..-1 }
    return allIncreasing || allDecreasing
}

fun isSafeWithDampener(report: List<Int>): Boolean {
    if (isSafe(report)) return true

    for (i in report.indices) {
        val modifiedReport = report.toMutableList().apply { removeAt(i) }
        if (isSafe(modifiedReport)) return true
    }
    return false
}
