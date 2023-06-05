package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.{Controller, State}

import cl.uchile.dcc.gwent.FirstRound
class ChoosingFirstPlayer extends State{

  override def chooseFirstPlayer(controller: Controller): Unit = this.changeState(controller,new FirstRound())
}
