package world.akebono.models

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table


object Users: Table() {
    val id: Column<Int> = integer("id").autoIncrement()
    val email: Column<String> = varchar("email", 100)
    val username: Column<String> = varchar("username", 100)
    val fullName: Column<String> = varchar("full_name", 100)

    override val primaryKey = PrimaryKey(id)
}

data class User(val id: Int,
                val email: String,
                val username: String,
                val fullName: String,)