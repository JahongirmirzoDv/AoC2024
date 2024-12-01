fun main() {
    val locationIdPairs = File("Day01.txt").readLines().map {
        val pair = it.split(" ")
        pair.first().toInt() to pair.last().toInt()
    }
    val leftIds = locationIdPairs.map { it.first }.sorted()
    val rightIds = locationIdPairs.map { it.second }.sorted()

    var totalDistance = 0
    locationIdPairs.indices.forEach { index ->
        totalDistance += abs(leftIds[index] - rightIds[index])
    }
    println("$totalDistance total")

    leftIds.sumOf { locationId ->
        locationId * rightIds.count { it == locationId }
    }.also { println(it) }
}
