package world.akebono.graphql.types.common

import kotlin.math.min

open class PaginatedList<T>(var items: List<T>, filter: PaginatedListFilter<T>?, sort: PaginatedListSort<T>?, val first: Int?, val offset: Int?) {

    init {
        if (filter !== null) {
            this.items = filter.apply(items);
        }
        if (sort !== null) {
            this.items = sort.apply(items);
        }
    }

    fun nodes(): List<T> {
        if (first !== null && offset !== null) {
            return items.slice(offset..min(items.size - 1, offset + first - 1))
        } else if (first !== null) {
            return items.slice(0..min(items.size - 1, first - 1))
        } else if (offset !== null) {
            return items.slice(min(items.size - 1, offset)..(items.size - 1))
        }
        return items
    }

    fun total(): Int {
        return items.size
    }
}