package ScalaTest
import com.QA.runner.SQLRunner
import com.QA.util.ArrayList

/**
 * @author rluu
 */
class SQLRunnerSpec extends UnitSpec with SQLRunner {
  
  "FindAll" should " get all in a cetain table " in {
      val rs = findAllSQL("Select * from customerorder")
      val list = new ArrayList()
      while(rs.next()){
       list.add(new Integer(rs.getInt(1)))
      }
    list.size() should be (2)
  }
  
  
    "insert" should "insert into a certain table " in {
      val rs =insertSQL("insert into customerorder values(1,12,'10/12/2023',1,1)")
      val find = findAllSQL("Select * from customerorder")
      val list = new ArrayList()
      while(find.next()){
       list.add(new Integer(find.getInt(1)))
      }
      list.size() should be (3)
  }
    
    
     "delete" should "delete from a certain table " in {
      val rs =insertSQL("delete from customerorder where status=1")
      val find = findAllSQL("Select * from customerorder")
      val list = new ArrayList()
      while(find.next()){
       list.add(new Integer(find.getInt(1)))
      }
      list.size() should be (2)
  } 
     
     "update" should "update from a certain table " in {
      val rs =insertSQL("update customerorder set status=3 where status=1 ")
      val find = findAllSQL("Select * from customerorder")
      val list = new ArrayList()
      while(find.next()){
       list.add(new Integer(find.getInt(1)))
      }
      list.size() should be (2)
  }     
     
}