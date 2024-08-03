package fyi.pauli.koard.board.piece

import kotlinx.serialization.Serializable

@Serializable
data class Color(
	var red: Int = 0,
	var green: Int = 0,
	var blue: Int = 0,
) {

	constructor(hex: String) : this() {
		val (r, g, b) = hexToRgb(hex)
		this.red = r
		this.green = g
		this.blue = b
	}

	private fun hexToRgb(hex: String): IntArray {
		val hexValue = hex.replace("#", "")
		val decimalValue = hexValue.toInt(16)

		val blue = decimalValue and 0xFF
		val green = (decimalValue shr 8) and 0xFF
		val red = (decimalValue shr 16) and 0xFF

		return intArrayOf(red, green, blue)
	}


	val hex: String
		get() = "#${(red shl 16 or (green shl 8) or blue).toString(16)}"

	init {
		require(
			listOf(red, green, blue).all { (0..255).contains(it) }
		)
	}

	object Colors {

		val BLACK: Color = Color(0, 0, 0)
		val WHITE: Color = Color(255, 255, 255)

	}
}