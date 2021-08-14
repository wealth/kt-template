package world.akebono.graphql.schemas

import com.expediagroup.graphql.generator.SchemaGeneratorConfig
import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.toSchema
import world.akebono.graphql.mutations.customer.BidCreateMutation
import world.akebono.graphql.types.customer.Query

val widgetQuery = Query()
val bidMutations = BidCreateMutation()
val CustomerSchema = toSchema(
    config = SchemaGeneratorConfig(introspectionEnabled = true, supportedPackages = listOf("world.akebono")),
    queries = listOf(TopLevelObject(widgetQuery)),
    mutations = listOf(TopLevelObject(bidMutations))
)
