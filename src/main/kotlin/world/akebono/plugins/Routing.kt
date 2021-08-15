package world.akebono.plugins

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.pebble.*
import io.ktor.response.*
import world.akebono.graphql.schemas.CustomerSchema
import world.akebono.graphql.server.KtorGraphQLHandler
import world.akebono.models.User

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        post("/akebono/main") {
            KtorGraphQLHandler(CustomerSchema).handle(this.call)
        }
        get("/akebono/preview") {
            val sampleUser = User(1, "yukai@pm.me", "yukai", "Dmitry Lubimov")
            call.respond(PebbleContent("pebble-index.html", mapOf("user" to sampleUser)))
        }
    }
}
