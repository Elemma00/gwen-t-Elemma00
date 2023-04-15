package cl.uchile.dcc
package gwent.model.cards

import gwent.model.cards.effects.AbstractEffect

/**
 *A trait that all cards have
 */
trait ICard{
    def applyCardEffect():Unit
    //def placeOnTable(table:Table):Unit
}

