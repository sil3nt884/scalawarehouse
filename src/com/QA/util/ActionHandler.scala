package com.QA.util
import javafx.event.EventHandler
import javafx.event._
import com.QA.runner.MongoRunner
import com.QA.runner.SQLRunner

/**
 * @author rluu
 * ActionHandler a class
 * handles Actions extends runners
 */
class ActionHander extends EventHandler[ActionEvent] with MongoRunner with SQLRunner{
   
  override def handle(event : ActionEvent) {
     insertSQL("insert into employee values(0,'ricky','luu','user3','pass')")
   } 
}