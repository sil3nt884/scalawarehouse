package com.QA.Handlers
import com.QA.util.ActionHander
import java.sql.ResultSet
import javafx.scene.control._
import javafx.event._
import com.QA.util.MethodThread

/**
 * @author rluu
 */
class LoginHandler(user : TextField ,  pass :TextField ) extends ActionHander {
  var username : String =_
  var password : String =_

 def handle(event: ActionEvent) {
    event.getSource match {
      case button: Button =>
        if (button.getText.equalsIgnoreCase("Login")) {
            username=user.getText;
            password=pass.getText
            new MethodThread(doLogin).start()
        }
      case _ =>
    }

  }

  def doLogin() {
    val rs = findAllSQL("Select * from employee")
    checkDatabase(rs.next(), rs, username, password)
  }

  def checkDatabase(check: Boolean, rs: ResultSet, usr: String, ps: String) {
    if (check) {
      val user = rs.getString(4)
      val pass = rs.getString(5)
      
      if (user.equalsIgnoreCase(usr) && pass.equalsIgnoreCase(ps)) {
            println("power!!!")
      }
      else{
      checkDatabase(rs.next() , rs, usr, ps )
      }
    }
    else {
       System.err.println("failed to login try again")
    }
  }
}
  
