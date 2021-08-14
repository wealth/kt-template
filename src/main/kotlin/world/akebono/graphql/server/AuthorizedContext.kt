package world.akebono.graphql.server

import com.expediagroup.graphql.generator.execution.GraphQLContext
import world.akebono.models.User

data class AuthorizedContext(
    val authorizedUser: User? = null,
    var guestUUID: String? = null,
    val customHeader: String? = null
) : GraphQLContext