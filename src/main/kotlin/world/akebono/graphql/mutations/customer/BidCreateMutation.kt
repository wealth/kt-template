package world.akebono.graphql.mutations.customer

import world.akebono.graphql.mutations.BaseInput
import world.akebono.graphql.mutations.BaseMutation
import world.akebono.graphql.mutations.BasePayload
import world.akebono.graphql.types.customer.Bid

data class BidCreateInput(
    val value: String) : BaseInput()
data class BidCreatePayload(
    val bid: Bid? = null) : BasePayload()

class BidCreateMutation : BaseMutation<BidCreateInput, BidCreatePayload>(payloadForError = BidCreatePayload()) {
    fun bidCreate(input: BidCreateInput): BidCreatePayload {
        return tryResolve(input) {
            throw NotImplementedError()
            BidCreatePayload(bid = Bid(1, "assa"))
        }
    }
}