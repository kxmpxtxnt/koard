package fyi.pauli.koard.game.player

import kotlinx.serialization.Serializable
import kotlin.random.Random

/**
 * Helper class which queues all players in this game.
 * @see Player
 */
@Serializable
class PlayerQueue<T : Player>(
	/**
	 * Collection of all players in the game associated by their [index].
	 * @see Player
	 */
	private val queue: MutableList<T> = mutableListOf(),
) {

	/**
	 * Index which points to the [currentPlayer].
	 */
	private var index: Int = 0

	/**
	 * Gets the current player pointed at by the [index].
	 * @see Player
	 * @see PlayerQueue.index
	 */
	val currentPlayer: T
		get() = queue[index]

	/**
	 * Gets next player in [queue]. Depending on [preview] pointer will move.
	 * @param preview Whether the [index] changes when getting the next player.
	 * @see Player
	 * @see PlayerQueue.index
	 */
	fun nextPlayer(preview: Boolean = false): T {
		return queue.getOrNull(if (preview) index + 1 else ++index).let {
			when (it != null) {
				true -> it
				else -> if (preview) queue[0] else run {
					index = 0
					nextPlayer(false)
				}
			}
		}
	}

	/**
	 * Adds given [player] to the [queue] at given [position].
	 * @param position position which the player will be placed in the queue.
	 * @param player [Player] to add to the given [position] to the queue.
	 * @see Player
	 */
	fun addPlayer(position: Int = queue.size, player: T) {
		queue.add(position, player)
	}

	/**
	 * Operator function `queue += player` to simply add a [player] to the end of the [queue].
	 * @param player [Player] to add to the [queue].
	 * @see Player
	 * @see PlayerQueue.addPlayer
	 */
	operator fun plusAssign(player: T) = addPlayer(player = player)

	/**
	 * Operator function `queue[position] = player` to set [player] to special [position] in the [queue].
	 * @param position Position which the player will be placed in the [queue].
	 * @param player [Player] to add to the given [position] to the queue.
	 * @see Player
	 * @see PlayerQueue.addPlayer
	 */
	operator fun set(position: Int, player: T) = addPlayer(position, player)

	/**
	 * Removes player by using the [index]
	 * @param index Index at which the player will be removed.
	 * @see PlayerQueue.index
	 */
	fun removePlayer(index: Int) {
		queue.removeAt(index)
	}

	/**
	 * Operator function `queue -= 2` to simply remove player at given [index].
	 * @param index Index at which the player will be removed.
	 * @see PlayerQueue.removePlayer
	 */
	operator fun minusAssign(index: Int) = removePlayer(index)

	/**
	 * Removes given [player] from [queue].
	 * @param player Player to remove from the queue.
	 * @see Player
	 */
	fun removePlayer(player: T) {
		queue.remove(player)
	}

	/**
	 * Operator function `queue -= player` to simply remove player at given [index].
	 * @param player [Player] to remove from the [queue].
	 * @see PlayerQueue.removePlayer
	 */
	operator fun minusAssign(player: T) = removePlayer(player)

	/**
	 * Operator function `queue[position]` to get player at given [position].
	 * @param position Position to get the player from.
	 * @return player at given position or null when there is no player.
	 * @see Player
	 */
	operator fun get(position: Int): Player? {
		return queue.getOrNull(position)
	}

	/**
	 * Random shuffles the player [queue].
	 * @param random Random instance which will be used to shuffle.
	 * @see Random
	 */
	fun shuffle(random: Random = Random) = queue.shuffle(random)
}