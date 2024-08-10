package fyi.pauli.koard.tests.game

import fyi.pauli.koard.game.player.Player
import fyi.pauli.koard.game.queue.PlayingQueue
import kotlinx.serialization.Serializable
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class PlayingQueueTests {

	@Serializable
	data class TestPlayer(val name: String) : Player()

	private val first = TestPlayer("1")
	private val second = TestPlayer("2")

	private val queue = object : PlayingQueue<Player>(queue = mutableListOf(first, second)) {}

	@Test
	fun `currentPlayer should be player first`() {
		assertEquals(first, queue.current)
	}

	@Test
	fun `nextPlayer should be player second`() {
		assertEquals(second, queue.next())
	}

	@Test
	fun `index pointer should move`() {
		assertEquals(first, queue.current)
		assertNotEquals(first, queue.next())
		assertEquals(second, queue.current)
	}

	@Test
	fun `index pointer should not move when using nextPlayerPreview`() {
		assertEquals(second, queue.next(true))
		assertEquals(first, queue.current)
	}
}