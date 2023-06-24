package cl.uchile.dcc
package gwent.model.cards

import gwent.model.table.PlayerTable

import cl.uchile.dcc.gwent.model.cards.effects.Effect
/**
 *A trait that all cards have
 */
trait ICard{
    def applyCardEffect():Unit
    def lineEffect(effect: Effect):Unit
    def placeOnTable():Unit
    def registerTable(o : PlayerTable): Unit
    def notifyTable(): Unit
    def getName():String
    def play(o : PlayerTable): Unit
}

