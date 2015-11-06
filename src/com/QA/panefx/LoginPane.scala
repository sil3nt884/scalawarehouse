package com.QA.panefx

import javafx.scene.layout.VBox
import javafx.scene.Scene;
import javafx.scene.control._
import javafx.geometry.Insets
import com.QA.Handlers.LoginHandler
import javafx.scene.Group;
import javafx.stage._


/**
 * @author rluu
 */
class LoginPane extends Stage {
  val login = new Button("Login")
  val username = new TextField
  val password = new PasswordField()
  val scene = new Scene(new Group());
  
  def this (name : String) {
    this()
    
    setTitle(name)
  }
  
  
  
  def createLoginPane() = {
    val box = new VBox()
    box.setPadding(new Insets(10));
    box.setSpacing(8)
    login.setOnAction(new LoginHandler(username,password))
    box.getChildren.addAll(username,password,login)
    box
  }
  
}