package fyi.pauli.koard.game.queue

import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
abstract class PlayingQueue<Q : Queueable>(
	/**
	 * Collection of all queueable items in the game associated by their [index].
	 * @see Q
	 */
	protected val queue: MutableList<Q> = mutableListOf(),
) {

	/**
	 * Index which points to the [current] queueable.
	 * @see Q
	 */
	protected var index: Int = 0

	/**
	 * Gets the current queueable item pointed at by the [index].
	 * @see Q
	 * @see PlayingQueue.index
	 */
	val current: Q
		get() = queue[index]

	/**
	 * Gets next queueable item in [queue]. Depending on [preview] pointer will move.
	 * @param preview Whether the [index] changes when getting the next queueable item.
	 * @see Q
	 * @see PlayingQueue.index
	 */
	fun next(preview: Boolean = false): Q {
		return queue.getOrNull(if (preview) index + 1 else ++index).let {
			when (it != null) {
				true -> it
				else -> if (preview) queue[0] else run {
					index = 0
					next(false)
				}
			}
		}
	}

	/**
	 * Operator function `queue += queueable` to simply add a [queueable] to the end of the [queue].
	 * @param queueable [Q] to add to the [queue].
	 * @see Q
	 */
	operator fun plusAssign(queueable: Q) {
		queue.add(queueable)
	}

	/**
	 * Operator function `queue[position] = queueable` to set [queueable] item to special [position] in the [queue].
	 * @param position Position which the queueable will be placed in the [queue].
	 * @param queueable [Q] to add to the given [position] to the queue.
	 * @see Q
	 */
	operator fun set(position: Int, queueable: Q) = queue.set(position, queueable)

	/**
	 * Operator function `queue -= 2` to simply remove queueable item at given [index].
	 * @param position Index at which the queueable item will be removed.
	 */
	operator fun minusAssign(position: Int) {
		queue.removeAt(position)
	}

	/**
	 * Operator function `queue -= queueable` to simply remove a [queueable] item.
	 * @param queueable [Q] to remove from the [queue].
	 */
	operator fun minusAssign(queueable: Q) {
		queue.remove(queueable)
	}

	/**
	 * Operator function `queue[position]` to get queueable item at given [position].
	 * @param position Position to get the queueable from.
	 * @return Q at given position or null when there is no queueable item.
	 * @see Q
	 */
	operator fun get(position: Int): Q? {
		return queue.getOrNull(position)
	}

	/**
	 * Random shuffles the queueable items [queue].
	 * @param random Random instance which will be used to shuffle.
	 * @see Random
	 */
	fun shuffle(random: Random = Random) = queue.shuffle(random)
}