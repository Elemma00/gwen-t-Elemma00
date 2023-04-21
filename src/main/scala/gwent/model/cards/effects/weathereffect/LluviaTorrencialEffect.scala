package cl.uchile.dcc
package gwent.model.cards.effects.weathereffect

object LluviaTorrencialEffect extends AbstractEffectWeather("Lluvia Torrencial"){
  override def applyEffect(): Unit = {
    println("a todas las cartas de asedio le asigno el valor 1")
  }
}
