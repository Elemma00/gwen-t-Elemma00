package cl.uchile.dcc
package gwent.model.cards.unitscards

import gwent.model.cards.effects.AbstractEffect
import gwent.model.cards.unitscards.AbstractUnitCard


/** A class representing a Siege Unit Card
 *
 *
 * @param name     name of the Siegue Unit
 * @param strength strength points
 * @param effect   the effect's card
 * @author Elemma00
 */

class SiegeUnit(private val name: String, private val strength: Int, private val effect: AbstractEffect)
  extends AbstractUnitCard(name, strength, effect) {

  // override def placeOnTable(/* table:Table */): Unit = {}
  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[SiegeUnit]) {
      val other = o.asInstanceOf[SiegeUnit]
      (this eq other) ||
        other.name == name &&
          other.strength == strength &&
          other.effect == effect
    } else {
      false
    }
  }

}
