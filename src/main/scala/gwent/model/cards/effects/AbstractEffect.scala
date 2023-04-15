package cl.uchile.dcc
package gwent.model.cards.effects

import gwent.model.cards.effects.TEffect


/**
 * An abstract class that represent the effects that a card have
 * @param name
 */
abstract class AbstractEffect(private val name: String) extends TEffect {
  def getName: String = name
}
