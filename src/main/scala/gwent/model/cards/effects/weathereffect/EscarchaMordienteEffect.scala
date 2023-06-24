package cl.uchile.dcc
package gwent.model.cards.effects.weathereffect
import gwent.model.cards.ICard
import gwent.model.table.PlayerTable

object EscarchaMordienteEffect extends AbstractEffectWeather("Escarcha Mordiente"){
  override def applyEffect(card: ICard, table: PlayerTable): Unit = {
    val meleeZone = table.getMeleeZone
    for (melee <- meleeZone){
      melee.currentStrength = melee.strengthWithoutWeather
      melee.buffWeather = 1
      melee.currentStrength += melee.buffWeather
      melee.strengthWithoutWeather =  melee.currentStrength - melee.buffWeather
    }
    println("le sumo 1 de fuerza a las cartas cuerpo a cuerpo")
  }
}

