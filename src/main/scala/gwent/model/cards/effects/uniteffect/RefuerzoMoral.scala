package cl.uchile.dcc
package gwent.model.cards.effects.uniteffect

import java.util.Objects


/**
 * a singleton Object that represent the effect "Refuerzo Moral"
 * this effect adds one point of strength to all cards in the same line
 */
object RefuerzoMoral extends AbstractEffectUnit("Refuerzo Moral"){
  override def applyEffect(): Unit = {println("me aplico a todas la cartas de la linea y les doy 1 de fuerza")}
  
}
