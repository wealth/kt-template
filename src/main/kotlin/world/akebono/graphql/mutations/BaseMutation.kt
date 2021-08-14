package world.akebono.graphql.mutations

import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import world.akebono.graphql.types.common.Error

open class BaseInput(val clientMutationId: String? = null)
open class BasePayload(open var error: Error? = null)
open class BaseMutation<I: BaseInput, P: BasePayload>(val payloadForError: P) {
    @GraphQLIgnore
    fun tryResolve(input: I, resolver: I.() -> P): P {
        return runCatching {
            throw NotImplementedError()
            return resolver(input)
        }.getOrElse { e ->
            payloadForError.error = Error(
                code = e.javaClass.simpleName,
                message = e.localizedMessage,
                backtrace = e.stackTraceToString().slice(0..100))
            return payloadForError
        }
    }
}