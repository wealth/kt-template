package world.akebono.graphql.types.customer

import world.akebono.graphql.types.common.PaginatedList
import world.akebono.graphql.types.common.PaginatedListFilter
import world.akebono.graphql.types.common.PaginatedListSort
import world.akebono.graphql.types.common.filter.IdFilter
import world.akebono.graphql.types.common.sort.IdSort

class BidsPaginatedListFilter(val id: IdFilter<Bid>? = null) : PaginatedListFilter<Bid>() {
    override fun apply(items: List<Bid>): List<Bid> {
        var result = items;
        if (id !== null) {
            result = id.apply(items)
        }
        return result
    }
}

class BidsPaginatedListSort(val id: IdSort<Bid>? = null) : PaginatedListSort<Bid>() {
    override fun apply(items: List<Bid>): List<Bid> {
        return items
    }

}
class BidsPaginatedList(
    items: List<Bid>,
    filter: BidsPaginatedListFilter? = null,
    sort: BidsPaginatedListSort? = null,
    first: Int? = null,
    offset: Int? = null) : PaginatedList<Bid>(
    items = items,
    filter = filter,
    sort = sort,
    first = first,
    offset = offset)

class Query {
    fun bid(id: Int): Bid? {
        return Bid(1, "assa")
    }

    fun bids(first: Int? = null, offset: Int? = null, filter: BidsPaginatedListFilter? = null, sort: BidsPaginatedListSort? = null): BidsPaginatedList {
        return BidsPaginatedList(listOf(Bid(1, "assa"), Bid(1, "assa")), filter, sort, first, offset)
    }
}