package cl.uchile.dcc
package gwent.model.cards.unitscards

import gwent.model.cards.{Effect, ICard}


class MeleeUnit(private val name: String, private var strength: Int) extends ICard {
  override def effect(): Effect = {
    new Effect
  }

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[MeleeUnit]) {
      val o = other.asInstanceOf[MeleeUnit]
      if (this.name == o.name) {
        if (this.strength == o.strength) {
          true
        } else false
      } else false
    } else false
  }

  override def toString: String = {
    s"name: $name strength: $strength"
  }

}
