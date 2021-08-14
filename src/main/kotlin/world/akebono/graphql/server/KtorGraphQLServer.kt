package world.akebono.graphql.server

import com.expediagroup.graphql.server.execution.GraphQLRequestHandler
import com.expediagroup.graphql.server.execution.GraphQLServer
import com.fasterxml.jackson.databind.ObjectMapper
import graphql.GraphQL
import graphql.schema.GraphQLSchema
import io.ktor.request.*

class KtorGraphQLServer(
    requestParser: KtorGraphQLRequestParser,
    contextFactory: KtorGraphQLContextFactory,
    requestHandler: GraphQLRequestHandler
) : GraphQLServer<ApplicationRequest>(requestParser, contextFactory, requestHandler)

fun getGraphQLServer(mapper: ObjectMapper, schema: GraphQLSchema): KtorGraphQLServer {
    val dataLoaderRegistryFactory = KtorDataLoaderRegistryFactory()
    val requestParser = KtorGraphQLRequestParser(mapper)
    val contextFactory = KtorGraphQLContextFactory()
    val graphQL = GraphQL.newGraphQL(schema).build()
    val requestHandler = GraphQLRequestHandler(graphQL, dataLoaderRegistryFactory)

    return KtorGraphQLServer(requestParser, contextFactory, requestHandler)
}