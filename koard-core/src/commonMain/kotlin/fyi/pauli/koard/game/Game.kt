package fyi.pauli.koard.game

import fyi.pauli.koard.game.player.Player
import fyi.pauli.koard.game.player.PlayerQueue
import kotlinx.datetime.LocalDateTime

abstract class Game<P: Player> {

	abstract val expiration: Result<LocalDateTime>

	private val players: PlayerQueue<P> = PlayerQueue()

	val currentPlayer: Player
		get() = players.currentPlayer

	val nextPlayer: Player
		get() = players.nextPlayer

}
