package fyi.pauli.koard.game

import fyi.pauli.koard.board.Board
import fyi.pauli.koard.game.player.Player
import fyi.pauli.koard.game.queue.PlayingQueue
import kotlinx.datetime.LocalDateTime

abstract class Game {

	abstract val queue: PlayingQueue<*>

	abstract val expiration: LocalDateTime?
	abstract val board: Board

}
