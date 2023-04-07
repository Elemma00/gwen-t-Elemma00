package cl.uchile.dcc
package gwent.model.cards.unitscards

import gwent.model.cards.{Effect, ICard}

/** A class representing a Distance Unit Card
 *
 * a Unit card is defined by its name and strength
 *
 * @param name
 * @param strength
 *
 * @author Elemma00
 */

class DistanceUnit(private val name: String, private var strength: Int) extends ICard{

  override def effect(): Effect = {
    new Effect
  }

  override def equals(other: Any): Boolean = {
    other match {
      case o: DistanceUnit =>
        if (this.name == o.name) {
          if (this.strength == o.strength) {
            true
          } else false
        } else false
      case _ => false
    }

  }

  /** method that returns a String with name's card and its strength
   *
   */
  override def toString: String = {
    s"name: $name strength: $strength"
  }
}
