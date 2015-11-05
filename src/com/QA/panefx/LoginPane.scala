package com.QA.panefx

import javafx.scene.layout.VBox
import javafx.scene.control._
import javafx.geometry.Insets
import com.QA.util.ActionHander



/**
 * @author rluu
 */
class LoginPane extends ActionHander {
  val login = new Button("Login")
  val username = new TextField
  val password = new PasswordField()
  
  def createLoginPane() = {
    val box = new VBox()
    box.setPadding(new Insets(10));
    box.setSpacing(8)
    login.setOnAction(this)
    box.getChildren.addAll(username,password,login)
    box
  }
  
}