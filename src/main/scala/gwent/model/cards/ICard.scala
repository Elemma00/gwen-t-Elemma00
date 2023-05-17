package cl.uchile.dcc
package gwent.model.cards

import gwent.model.table.PlayerTable
/**
 *A trait that all cards have
 */
trait ICard{
    def applyCardEffect():Unit
    def play():Unit
    def placeOnTable(table:PlayerTable):Unit
}

