package fyi.pauli.koard.tests.game

import fyi.pauli.koard.game.player.Player
import fyi.pauli.koard.game.player.PlayerQueue
import kotlinx.serialization.Serializable
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class PlayerQueueMoveTests {

	@Serializable
	data class TestPlayer(val name: String) : Player()

	private val first = TestPlayer("1")
	private val second = TestPlayer("2")
	private val third = TestPlayer("3")

	private val queue = PlayerQueue(
		mutableListOf(first, second, third)
	)

	@Test
	fun `currentPlayer should be player first`() {
		assertEquals(first, queue.currentPlayer)
	}

	@Test
	fun `nextPlayer should be player second`() {
		assertEquals(second, queue.nextPlayer())
	}

	@Test
	fun `index pointer should move`() {
		assertEquals(first, queue.currentPlayer)
		assertNotEquals(first, queue.nextPlayer())
		assertEquals(second, queue.currentPlayer)
	}

	@Test
	fun `index pointer should not move when using nextPlayerPreview`() {
		assertEquals(second, queue.nextPlayer(true))
		assertEquals(first, queue.currentPlayer)
	}
}