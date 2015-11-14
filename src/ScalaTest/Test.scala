package ScalaTest
import com.QA.runner.MongoRunner
import com.QA.entities.Product
import com.QA.util.ArrayList

/**
 * @author rluu
 */
class Test  extends UnitSpec with MongoRunner{
  
   def listLenght (i : Integer ,list : ArrayList)  {
      if(i < list.size()){
        System.out.println("test");
        listLenght(i.+(1) , list)
      }

     
      
    }
  
  "This " should "loop" in {
      val list = this.findAll(new Product())
      listLenght(0, list)
   
  }
}