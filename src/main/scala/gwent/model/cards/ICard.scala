package cl.uchile.dcc
package gwent.model.cards

trait ICard{
    val name: String
    def effect():Effect
}

