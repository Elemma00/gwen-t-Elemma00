package cl.uchile.dcc
package gwent.model.cards.unitscards

import gwent.model.cards.ICard

trait UnitCard extends ICard {
  var strength: String
  val typeCard: String
}
