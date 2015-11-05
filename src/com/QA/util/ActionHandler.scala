package com.QA.util
import javafx.event.EventHandler
import javafx.event._

/**
 * @author rluu
 */
class ActionHander extends EventHandler[Event] {
  override def handle(event : Event) {
        System.out.println("My Very Own Private Handler For All Kind Of Events");
    }
}