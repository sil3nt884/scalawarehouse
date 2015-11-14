package ScalaTest


/**
 * @author rluu
 */
class CustomerOrderHandler extends UnitSpec  {
  
  "Test if updateStatement  statement varialbe sets" should "as previous statement" in{
  val statement = "Update customerorder , orders , set status=2 , EmplyoeeID=12 where (customerID=1 and orders.ProductID=1 and Date='10/11/2015')"
  statement should be ("Update customerorder , orders , set status=2 , EmplyoeeID=12 where (customerID=1 and orders.ProductID=1 and Date='10/11/2015')")
  }

  
}