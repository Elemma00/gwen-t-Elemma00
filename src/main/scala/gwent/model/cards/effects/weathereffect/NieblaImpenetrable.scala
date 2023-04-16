package cl.uchile.dcc
package gwent.model.cards.effects.weathereffect

object NieblaImpenetrable extends AbstractEffectWeather("Niebla Impenetrable"){
  override def applyEffect(): Unit = {
    println("Le sumo 1 de fuerza a las cartas de distancia en mi campo")
  }
}
