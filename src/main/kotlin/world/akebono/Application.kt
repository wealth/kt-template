package world.akebono

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import world.akebono.plugins.*

fun main() {
    embeddedServer(Netty, port = 5000, host = "0.0.0.0") {
        configureRouting()
        configureHTTP()
        configureMonitoring()
        configureTemplating()
        configureSerialization()
        configureSockets()
    }.start(wait = true)
}
