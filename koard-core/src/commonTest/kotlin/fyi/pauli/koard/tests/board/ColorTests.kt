package fyi.pauli.koard.tests.board

import fyi.pauli.koard.board.piece.Color
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class ColorTests {

	@Test
	fun badConfigurationShouldThrow() {
		assertFails {
			Color(244, 2, 256)
		}
	}

	@Test
	fun `rgb to hex`() {
		assertEquals(Color(66, 245, 155).hex, "#42f59b")
	}

	@Test
	fun `color from hex`() {
		assertEquals(Color("#42f59b"), Color(66, 245, 155))
	}
}

