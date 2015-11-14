package ScalaTest
import org.scalatest._
import com.QA.Handlers.InventoryHandler
import com.QA.entities.Inventory
import com.QA.runner.SQLRunner

/**
 * @author rluu
 */
class InventoryHandlerSpec extends UnitSpec with SQLRunner {
  
  
  
  "A cetain amount of products " should "be" in {
    updateSQL("Update inventory set quantity= quantity - 12 where product_id=2 and location='A1'")
    val rs =  this.findAllSQL("Select quantity, product_id from inventory")
    var row1 = 0 
    var row2 = 0 
   while(rs.next()){
     row1 =rs.getInt(1)
     row2 = rs.getInt(2)
     
   }
    println(row1)
    println(row2)
   val valid  = (row1==(-12) && row2==1)
   assertResult(true)(valid)
  }
  

  
}