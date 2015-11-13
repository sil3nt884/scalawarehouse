package ScalaTest
import org.scalatest._
import com.QA.runner.SQLRunner
/**
 * @author rluu
 */
class CheckOutHandlerSpec extends FlatSpec with SQLRunner {
  
  
  "Checks if an update can be made to the database this" should "update on success" in {
   
    updateSQL("Update customerorder , orders set Status=3, EmplyoeeID=12 Where (CustomerID=1 and orders.ProductID=1 and Date='10/11/2015')")
    val rs = findAllSQL("select * from customerorder where status=3")
    val list = new Array[Int](2) 
    while(rs.next()){
        list(1)=rs.getInt(4)
    }
    assertResult(list(1))(3)
  }
  
  
}