package cl.uchile.dcc
package gwent.model.cards.unitscards


import gwent.model.cards.ICard
import gwent.model.cards.effects.AbstractEffect
import gwent.model.cards.unitscards.AbstractUnitCard

/** A class representing a Distance Unit Card
 *
 *
 * @param name     name of the Distance Unit
 * @param strength point of strength
 * @param effect   the effect's card
 * @author Elemma00
 */

class DistanceUnit(private val name: String, private var strength: Int, private var effect: AbstractEffect)
  extends AbstractUnitCard(name, strength, effect) {

  // override def placeOnTable(/* table:Table */): Unit = {}
  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[DistanceUnit]) {
      val other = o.asInstanceOf[DistanceUnit]
      (this eq other) ||
        other.name == name &&
          other.strength == strength &&
          other.effect == effect
    } else {
      false
    }
  }

}
