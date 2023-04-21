package cl.uchile.dcc
package gwent.model.cards.effects.weathereffect

object ClimaDespejadoEffect extends AbstractEffectWeather("Clima Despejado"){
  override def applyEffect(): Unit = {
    println("Quito todos los efectos de cartas de clima que hayan en el campo")
  }
}
