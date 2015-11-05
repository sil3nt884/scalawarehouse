package com.QA.util
import javafx.event.EventHandler
import javafx.event._
import com.QA.runner.MongoRunner
import com.QA.runner.SQLRunner
import javafx.scene.control._

/**
 * @author rluu
 * ActionHandler a class
 * handles Actions extends runners
 */
class ActionHander extends EventHandler[ActionEvent] with MongoRunner with SQLRunner{
   
  override def handle(event : ActionEvent) {
     event.getSource match{
       case button : Button =>
           if(button.getText.equalsIgnoreCase("Login")){
               new Thread(new MethodThread(doLogin)).start()
           }
       case _ =>
     }
   } 
  def doLogin () {
     System.out.println("it works") 
  }
  
}

