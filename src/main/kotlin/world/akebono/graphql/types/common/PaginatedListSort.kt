package world.akebono.graphql.types.common

abstract class PaginatedListSort<T> {
    abstract fun apply(items: List<T>): List<T>
}