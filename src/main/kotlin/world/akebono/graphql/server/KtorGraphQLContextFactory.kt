package world.akebono.graphql.server;

import com.expediagroup.graphql.server.execution.GraphQLContextFactory
import io.ktor.request.*

class KtorGraphQLContextFactory : GraphQLContextFactory<AuthorizedContext, ApplicationRequest> {
    override suspend fun generateContext(request: ApplicationRequest): AuthorizedContext {
        val loggedInUser = null

        // Parse any headers from the Ktor request
        val customHeader: String? = request.headers["my-custom-header"]

        return AuthorizedContext(loggedInUser, customHeader = customHeader)
    }
}