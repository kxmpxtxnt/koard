package fyi.pauli.koard.board

import kotlinx.serialization.Serializable

@Serializable
abstract class Location<X, Y> {

  abstract val x: X
  abstract val y: Y

  abstract val id: Int
}