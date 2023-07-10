package cl.uchile.dcc
package gwent.controller

import gwent.model.table.GeneralTable

trait ControllerObserver {

  def update(generalTable: GeneralTable): Unit = {}
}
