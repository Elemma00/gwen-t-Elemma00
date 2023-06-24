package cl.uchile.dcc
package gwent.model.cards.effects.weathereffect
import gwent.model.cards.ICard
import gwent.model.table.PlayerTable

object NieblaImpenetrableEffect extends AbstractEffectWeather("Niebla Impenetrable"){
  override def applyEffect(card: ICard, table: PlayerTable): Unit = {
    val distanceZone = table.getDistanceZone
    for (distance <- distanceZone) {
      distance.currentStrength = distance.strengthWithoutWeather
      distance.buffWeather = 1
      distance.currentStrength += distance.buffWeather
      distance.strengthWithoutWeather = distance.currentStrength - distance.buffWeather
    }
    println("Le sumo 1 de fuerza a las cartas de distancia en mi campo")
  }


}
