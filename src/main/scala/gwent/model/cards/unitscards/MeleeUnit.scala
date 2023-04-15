package cl.uchile.dcc
package gwent.model.cards.unitscards

import gwent.model.cards.effects.AbstractEffect

/** A class representing a Melee Unit Card
 *
 *
 * @param name name of the Melee Unit
 * @param strength strength points
 * @param effect the card's effect
 * @author Elemma00
 */


class MeleeUnit(private val name: String, private val strength: Int, private val effect: AbstractEffect)
  extends AbstractUnitCard(name, strength, effect) {

  // override def placeOnTable(/* table:Table */): Unit = {}
  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[MeleeUnit]) {
      val other = o.asInstanceOf[MeleeUnit]
      (this eq other) ||
        other.name == name &&
          other.strength == strength &&
          other.effect == effect
    } else {
      false
    }
  }
}
