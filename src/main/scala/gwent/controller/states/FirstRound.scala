package cl.uchile.dcc
package gwent

import gwent.controller.{Controller, State}

import cl.uchile.dcc.gwent.controller.states.WaitingAction
class FirstRound extends State {

  override def setHands(controller: Controller): Unit = this.changeState(controller,new WaitingAction())
}
