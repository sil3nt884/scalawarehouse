package com.QA.panefx

import javafx.scene.layout.VBox
import javafx.scene.Scene;
import javafx.scene.control._
import javafx.geometry.Insets
import com.QA.Handlers.LoginHandler
import javafx.scene.Group;
import javafx.stage._
import javafx.scene.layout._


/**
 * @author rluu
 */
class LoginPane  {
  val login = new Button("Login")
  val username = new TextField
  val password = new PasswordField()
  val userlb = new Label("Username")
  val passlb = new Label("Password")
  val stage = new Stage()
  
  def this (name : String ) {
    this()
    val root = new BorderPane() 
    stage.setTitle(name)
    root.setCenter(createLoginPane)
    stage.setScene(new Scene(root, 250, 160))
    stage.show()
     
  }
  
 
  
  def createLoginPane() = {
    val box = new VBox()
    box.setPadding(new Insets(10));
    box.setSpacing(8)
    login.setOnAction(new LoginHandler(username,password))
    box.getChildren.addAll(userlb, username, passlb, password,login)
    box
  }
  
}