package cl.uchile.dcc
package gwent.model.cards.unitscards

import gwent.model.cards.{Effect, ICard}



/** A class representing a Siege Unit Card
 *
 * a Unit card is defined by its name and strength
 *
 * @param name
 * @param strength
 *
 * @author Elemma00
 */

class SiegeUnit(private val name: String, private var strength:Int) extends ICard {


  override def effect(): Effect = {new Effect} 
  
  override def equals(other: Any): Boolean = {
    other match {
      case o: SiegeUnit =>
        if (this.name == o.name) {
          if (this.strength == o.strength) {
            true
          } else false
        } else false
      case _ => false
    }
  }

  override def toString: String = {
    s"name: $name strength: $strength"
  }
  
}
