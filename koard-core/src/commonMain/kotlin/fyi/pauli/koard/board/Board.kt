package fyi.pauli.koard.board

import fyi.pauli.koard.board.piece.Piece

interface Board<X, Y> {

  val pieces: MutableMap<Location<X, Y>, Piece>

  companion object {
    fun <X, Y> default(): Board<X, Y> {
      return object : Board<X, Y> {
        override val pieces: MutableMap<Location<X, Y>, Piece> = mutableMapOf()
      }
    }
  }
}