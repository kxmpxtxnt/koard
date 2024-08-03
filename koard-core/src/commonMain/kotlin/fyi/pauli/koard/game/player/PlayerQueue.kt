package fyi.pauli.koard.game.player

import kotlinx.serialization.Serializable
import kotlin.random.Random

/**
 * Helper class which queues all players in this game.
 * @see Player
 */
@Serializable
class PlayerQueue<T : Player>(
	val players: List<T> = emptyList()
) {

	/**
	 * Collection of all players in the game associated by their [index].
	 * @see Player
	 */
	private val queue: MutableList<T> = players.toMutableList()

	/**
	 * Index which points to the [currentPlayer].
	 */
	private var index: Int = 0

	/**
	 * Get next player in [queue] and moves [index] pointer to next spot.
	 * If the [queue] is at the end, the [index] will reset to 0
	 * @see Player
	 * @see PlayerQueue.index
	 */
	val nextPlayer: T
		get() = queue.getOrNull(++index).let {
			when (it != null) {
				true -> it

				false -> {
					index = 0
					nextPlayer
				}
			}
		}

	/**
	 * Gets the current player pointed at by the [index].
	 * @see Player
	 * @see PlayerQueue.index
	 */
	val currentPlayer: T
		get() = queue[index]

	/**
	 * Gets next player in [queue]. Will not move the [index] pointer.
	 * @see Player
	 */
	val nextPlayerPreview: T
		get() = queue.getOrNull(index + 1).let {
			when (it != null) {
				true -> it
				false -> queue[0]
			}
		}

	/**
	 * Adds given [player] to the [queue] at given [position].
	 * @param position position which the player will be placed in the queue.
	 * @param player Player to add to the given position to the queue.
	 * @see Player
	 */
	fun addPlayer(position: Int = queue.size, player: T) = queue.add(position, player)

	/**
	 * Operator function `queue += player` to simply add a [player] to the end of the [queue].
	 * @param player Player to add to the queue.
	 * @see Player
	 * @see PlayerQueue.addPlayer
	 */
	operator fun plusAssign(player: T) = addPlayer(player = player)

	/**
	 * Operator function `queue[position] = player` to set player to special [position] in the [queue].
	 * @param position position which the Player will be placed in the queue.
	 * @param player Player to add to the given position to the queue.
	 * @see Player
	 * @see PlayerQueue.addPlayer
	 */
	operator fun set(position: Int, player: T) = addPlayer(position, player)

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