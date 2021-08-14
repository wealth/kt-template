package world.akebono.graphql.types.common

abstract class PaginatedListFilter<T> {
    abstract fun apply(items: List<T>): List<T>
}