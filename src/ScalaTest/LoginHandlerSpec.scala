package ScalaTest
import org.scalatest._
import com.QA.util.ActionHander
import java.sql.ResultSet
import javafx.scene.control._
import javafx.event._
import com.QA.util.MethodThread
import javafx.scene.control.Alert.AlertType
import javax.swing.JOptionPane;
import com.QA.util.Session
import javafx.stage._
import javafx.concurrent.Task
import com.QA.runner.SQLRunner

/**
 * @author rluu
 */
class LoginHandlerSpec extends UnitSpec with SQLRunner {
  

  "An valid login" should "give allow an employee to login in" in{
     val rs = findAllSQL("Select username, password from employee where username='user12' and password='pass'")
     var user : String = "something"
     var pass : String = "something"
     while(rs.next()){
     user = rs.getString(1)
     pass = rs.getString(2)
     }
     val valid : Boolean = (user.equals("user12") && pass.equals("pass"))
     assertResult(true)(valid)
  }

  "An empty login" should "fail" in {
     val rs = findAllSQL("Select username, password from employee where username='' and password=''")
     var user : String = "something"
     var pass : String = "something"
     while(rs.next()){
     user = rs.getString(1)
     pass = rs.getString(2)
     }
     val valid : Boolean = (user.equals("") && pass.equals(""))
     assertResult(true)(valid)
  }
  
}