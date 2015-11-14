package ScalaTest
import com.QA.runner.MongoRunner
import com.QA.entities.Product

/**
 * @author rluu
 */
class MongoRunnerSpec extends UnitSpec with MongoRunner {
 
  "All objects " should "be found using findAll" in {
    val list = findAll(new Product())
    list.size() should be (2)
    list.get(0).toString() should be ("Document{{_id=563a3955187f410550522a87, Product=Product, ID=1, Price=5000, Name=Bob}}")
    list.get(1).toString() should be ("Document{{_id=563a3a43187f41103cf4454c, Product=Product, ID=2, Price=5000, Name=test2}}")
    
  }
  
  " A field in mongodb "should "be updated" in {
    update(1, new Product(), "Name", "Bob")
    val list = findAll(new Product())
    list.size() should be (2)
    list.get(0).toString() should be ("Document{{_id=563a3955187f410550522a87, Product=Product, ID=1, Price=5000, Name=Bob}}")
    list.get(1).toString() should be ("Document{{_id=563a3a43187f41103cf4454c, Product=Product, ID=2, Price=5000, Name=test2}}")
  }
  
}