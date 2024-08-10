package fyi.pauli.koard.board

import fyi.pauli.koard.board.piece.Piece

interface Board {

  val pieces: MutableMap<Position, Piece>

}