package com.QA.Handlers
import com.QA.util.ActionHander
import java.sql.ResultSet
import javafx.scene.control._
import javafx.event._
import com.QA.util.MethodThread
import javafx.scene.control.Alert.AlertType
import javax.swing.JOptionPane;


/**
 * @author rluu
 */
class LoginHandler(user : TextField ,  pass :TextField ) extends ActionHander {
val  alert = new Alert(AlertType.INFORMATION);

  
  
 def handle(event: ActionEvent) {
    event.getSource match {
      case button: Button =>
        if (button.getText.equalsIgnoreCase("Login")) {
            new MethodThread(doLogin).start()
        }
      case _ =>
    }

  }
  def doLogin() {
    val rs = findAllSQL("Select * from employee")
    checkDatabase(rs.next(), rs, user.getText, pass.getText)
  }

  def checkDatabase(check: Boolean, rs: ResultSet, usr: String, ps: String) {
    if (check) {
      val user = rs.getString(4)
      val pass = rs.getString(5)
      
      if (user.equalsIgnoreCase(usr) && pass.equalsIgnoreCase(ps)) {
          JOptionPane.showMessageDialog(null, "Welcome")  
      }
      else{
      checkDatabase(rs.next() , rs, usr, ps )
      }
    }
    else {
        JOptionPane.showMessageDialog(null, "Failed to Log in") 
    }
  }
}
  
