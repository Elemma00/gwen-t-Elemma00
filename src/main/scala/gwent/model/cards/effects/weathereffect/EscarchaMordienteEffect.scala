package cl.uchile.dcc
package gwent.model.cards.effects.weathereffect

object EscarchaMordienteEffect extends AbstractEffectWeather("Escarcha Mordiente"){
  override def applyEffect(): Unit = {
    println("Le doy 1 de fuerza a todas la unidades cuerpo a cuerpo que tengo en mi campo")
  }
}

