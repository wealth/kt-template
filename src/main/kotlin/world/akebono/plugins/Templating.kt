package world.akebono.plugins

import com.mitchellbosecke.pebble.loader.ClasspathLoader
import io.ktor.pebble.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import world.akebono.models.User

fun Application.configureTemplating() {
    install(Pebble) {
        loader(ClasspathLoader().apply {
            prefix = "templates"
        })
    }
}
