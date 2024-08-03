package fyi.pauli.koard.board.piece

import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
abstract class Piece {
  abstract val identifier: Char

  @Serializable
  abstract class ColoredPiece : Piece() {

    abstract val color: Color
  }
}