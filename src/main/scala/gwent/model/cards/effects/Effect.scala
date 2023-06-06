package cl.uchile.dcc
package gwent.model.cards.effects

/**
 * a trait for effects
 */
trait Effect {
  //this method apply the effect on game
  def applyEffect(): Unit
}
