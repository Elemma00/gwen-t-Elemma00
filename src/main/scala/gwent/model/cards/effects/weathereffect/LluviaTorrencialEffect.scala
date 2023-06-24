package cl.uchile.dcc
package gwent.model.cards.effects.weathereffect
import gwent.model.cards.ICard
import gwent.model.table.PlayerTable

object LluviaTorrencialEffect extends AbstractEffectWeather("Lluvia Torrencial"){
  override def applyEffect(card: ICard, table: PlayerTable): Unit = {
    val siegueZone = table.getSiegueZone
    for (siegue <- siegueZone) {
      siegue.currentStrength = siegue.strengthWithoutWeather
      siegue.buffWeather = siegue.currentStrength - 1
      siegue.currentStrength = 1
      siegue.strengthWithoutWeather = siegue.currentStrength + siegue.buffWeather
    }
    println("a todas las cartas de asedio le asigno el valor 1")
  }
}
