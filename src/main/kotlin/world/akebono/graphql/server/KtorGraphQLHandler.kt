package world.akebono.graphql.server

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import graphql.schema.GraphQLSchema
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*

class KtorGraphQLHandler(schema: GraphQLSchema)  {
    private val mapper = jacksonObjectMapper()
    private val ktorGraphQLServer = getGraphQLServer(mapper, schema)

    /**
     * Handle incoming Ktor Http requests and send them back to the response methods.
     */
    suspend fun handle(applicationCall: ApplicationCall) {
        // Execute the query against the schema
        val result = ktorGraphQLServer.execute(applicationCall.request)

        if (result != null) {
            // write response as json
            val json = mapper.writeValueAsString(result)
            applicationCall.response.call.respond(json)
        } else {
            applicationCall.response.call.respond(HttpStatusCode.BadRequest, "Invalid request")
        }
    }
}