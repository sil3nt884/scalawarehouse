package ScalaTest
import org.scalatest._
import com.QA.runner.SQLRunner
import com.QA.entities.Inventory
import com.QA.util.ArrayList
import java.sql.ResultSet
/**
 * @author rluu
 */
class CheckOutHandlerSpec extends UnitSpec with SQLRunner {

  var picker = false;

  "Checks if an update can be made to the database this" should "update on success" in {

    updateSQL("Update customerorder , orders set Status=3, EmplyoeeID=12 Where (CustomerID=1 and orders.ProductID=1 and Date='10/11/2015')")
    val rs = findAllSQL("select * from customerorder where status=3")
    val list = new Array[Int](2)
    while (rs.next()) {
      list(1) = rs.getInt(4)
    }
    assertResult(list(1))(3)
  }

  def checkPicker(start: Int, list: ArrayList) {

    if (start < list.size()) {
      list.get(start) match {
        case line: Inventory =>
          if (line.getSize() >= 20) {
            picker = true
          } else {
            picker = false
          }
      }

      checkPicker(start.+(1), list)
    }

  }

  "check to see  if they product requires a picker if the product requires a picker the size " should "be greater than  or equal to 20" in {
    val result = findAllSQL("Select * from inventory where size=20")
    val list = new ArrayList()
    checkDatabase(result.next(), result)
    def checkDatabase(check: Boolean, rs: ResultSet) {
      if (check) {
        list.add(new Inventory(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5)))

        checkDatabase(rs.next(), rs)
      }

    }
    checkPicker(0, list)
    assertResult(picker)(true)
    
  }
}