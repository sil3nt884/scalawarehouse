package com.QA.util
import javafx.event.EventHandler
import javafx.event._
import com.QA.runner.MongoRunner
import com.QA.runner.SQLRunner

/**
 * @author rluu
 */
class ActionHander extends EventHandler[ActionEvent] with MongoRunner with SQLRunner{
   
  override def handle(event : ActionEvent) {
      println(event.getSource)
   }
  
  
  
}