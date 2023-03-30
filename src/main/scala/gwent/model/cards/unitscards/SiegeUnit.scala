package cl.uchile.dcc
package gwent.model.cards.unitscards

import gwent.model.cards.{Effect, ICard}

class SiegeUnit(private val name: String, private var strength:Int) extends ICard {


  override def effect(): Effect = {new Effect} 
  
  override def equals(other: Any): Boolean = {
    if(other.isInstanceOf[SiegeUnit]){
      val o = other.asInstanceOf[SiegeUnit]
      if(this.name == o.name) {
        if(this.strength == o.strength){
          true
        } else false
      }else false
    }else false
  }

  override def toString: String = {
    s"name: $name strength: $strength"
  }
  
}
