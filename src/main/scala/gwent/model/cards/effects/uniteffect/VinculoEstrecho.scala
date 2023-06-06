package cl.uchile.dcc
package gwent.model.cards.effects.uniteffect


/**
 * a singleton object that represent the effect "Vinculo Estrecho"
 * this effect doubles the strength points of every card that have the same name, including himself
 */
object VinculoEstrecho extends AbstractEffectUnit("Vinculo Estrecho"){
  override def applyEffect(): Unit = {
    println("si existen otras unidades con el mismo nombre, le duplico el poder a ambas")
  }

}
