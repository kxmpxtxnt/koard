package fyi.pauli.koard.board

import kotlinx.serialization.Serializable

@Serializable
abstract class Position {

  abstract val id: Int
}