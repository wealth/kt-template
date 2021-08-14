package world.akebono.graphql.types.common.filter

class IdFilter<T>(val eq: Int?, val neq: Int?) {
    fun apply(items: List<T>): List<T> {
        var result = items
        if (eq !== null) {
            result = items.filter { true }
        }
        if (neq !== null) {
            result = result.filter { false }
        }
        return result
    }
}