package cl.uchile.dcc
package gwent.model.cards

/**
 *A trait that all cards have
 */
trait ICard{
    def applyCardEffect():Unit
    def play():Unit
    
    //def placeOnTable(table:Table):Unit
}

