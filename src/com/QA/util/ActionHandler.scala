package com.QA.util
import javafx.event.EventHandler
import javafx.event._
import com.QA.runner.MongoRunner
import com.QA.runner.SQLRunner
import javafx.scene.control._
import java.sql.ResultSet
/**
 * @author rluu
 * ActionHandler a class
 * handles Actions extends runners
 */
trait ActionHander extends EventHandler[ActionEvent] with MongoRunner with SQLRunner {

  def handle(event: ActionEvent)
  

}
