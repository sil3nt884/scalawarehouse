package com.QA.panefx

import javafx.scene.layout.VBox
import javafx.scene.control._
import javafx.geometry.Insets
import com.QA.Handlers.LoginHandler



/**
 * @author rluu
 */
class LoginPane {
  val login = new Button("Login")
  val username = new TextField
  val password = new PasswordField()
  
  def createLoginPane() = {
    val box = new VBox()
    box.setPadding(new Insets(10));
    box.setSpacing(8)
    login.setOnAction(new LoginHandler(username,password))
    box.getChildren.addAll(username,password,login)
    box
  }
  
}