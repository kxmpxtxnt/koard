package fyi.pauli.koard.board.piece

import fyi.pauli.koard.board.Position
import kotlinx.serialization.Serializable

@Serializable
abstract class Piece {

  abstract val position: Position
  abstract val identifier: Char

  @Serializable
  abstract class ColoredPiece : Piece() {

    abstract val color: Color
  }
}