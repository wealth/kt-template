package world.akebono.graphql.mutations.manager

import world.akebono.graphql.mutations.BaseInput
import world.akebono.graphql.mutations.BaseMutation
import world.akebono.graphql.mutations.BasePayload
import world.akebono.graphql.types.customer.Bid

data class BidUpdateInput(
    val value: String) : BaseInput()
data class BidUpdatePayload(
    val widget: Bid? = null) : BasePayload()

class BidMutations : BaseMutation<BidUpdateInput, BidUpdatePayload>(payloadForError = BidUpdatePayload()) {
    fun bidUpdate(input: BidUpdateInput): BidUpdatePayload {
        return tryResolve(input) {
            throw NotImplementedError()
        }
    }
}