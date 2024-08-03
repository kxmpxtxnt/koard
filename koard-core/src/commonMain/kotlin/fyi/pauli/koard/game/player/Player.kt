package fyi.pauli.koard.game.player

import com.benasher44.uuid.Uuid
import com.benasher44.uuid.uuid4
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
abstract class Player {

	@Contextual
	val uid: Uuid = uuid4()

}