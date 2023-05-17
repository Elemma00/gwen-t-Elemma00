package cl.uchile.dcc
package gwent.model.table

import gwent.model.cards.ICard
import gwent.model.cards.weathercards.AbstractWeatherCard
import gwent.model.table.PlayerTable

import scala.collection.mutable.ArrayBuffer
import java.util.Objects


class GeneralTable(val tablePlayer1: PlayerTable, val tablePlayer2: PlayerTable)  {

  //Campo común de cartas de clima
  var weatherZone: AbstractWeatherCard = _
  
  def setWeatherCard(card:AbstractWeatherCard) : Unit = {
    weatherZone = card
  }

  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[GeneralTable]) {
      val other = o.asInstanceOf[GeneralTable]
      (this eq other) ||
        other.tablePlayer1 == tablePlayer1 &&
          other.tablePlayer2 == tablePlayer2 &&
          other.weatherZone == weatherZone
    } else {
      false
    }
  }

  override def hashCode(): Int = {
    Objects.hash(classOf[PlayerTable],tablePlayer1,tablePlayer2)
  }





}
