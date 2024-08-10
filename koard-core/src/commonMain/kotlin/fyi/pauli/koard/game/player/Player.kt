package fyi.pauli.koard.game.player

import com.benasher44.uuid.Uuid
import com.benasher44.uuid.uuid4
import fyi.pauli.koard.game.queue.Queueable
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
abstract class Player : Queueable {

  @Contextual
  val uid: Uuid = uuid4()

}