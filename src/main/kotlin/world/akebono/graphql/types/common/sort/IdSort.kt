package world.akebono.graphql.types.common.sort

data class IdSort<T>(val direction: String?) {
    fun apply(items: List<T>): List<T> {
        var result = items
        if (direction == "asc") {
            return items.sortedBy { it.hashCode() }
        } else if (direction == "desc") {
            return items.sortedBy { it.hashCode() }
        }
        return result
    }
}