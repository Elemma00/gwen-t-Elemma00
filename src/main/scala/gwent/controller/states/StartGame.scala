package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.{Controller, State}
class StartGame extends State{
  override def setPlayersAndTable(controller: Controller): Unit = this.changeState(controller, new ChoosingFirstPlayer())
  override def isStartGame(): Boolean = true
}
