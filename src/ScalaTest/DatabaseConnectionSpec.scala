package ScalaTest
import org.scalatest._
import com.QA.Connectors.DataConfig
import com.mongodb.MongoClient
import java.net.ConnectException
import com.mongodb.MongoTimeoutException





/**
 * @author rluu
 */
class DatabaseConnectionSpc extends UnitSpec {
  
  "A  SQL connection " should "return a false  on isClosed()" in {
    val connection : DataConfig = new DataConfig()
     assertResult(false)(connection.dataSource().getConnection.isClosed())
  }
  
  "If a database is not avaialbe a connection" should "return null" in{
    val connection : DataConfig = new DataConfig()
     cancel()
  }
  
  "if a mongo Connection exist this " should "Connect to the database" in {
    val connection : DataConfig = new DataConfig()
    assertResult("localhost/127.0.0.1:27017")(connection.MongoClient().getAddress.getSocketAddress.toString())
  }
  
   "if a mongo Connection  does not exist this " should "fail" in {
     cancel()
    val connection : DataConfig = new DataConfig()
     intercept[MongoTimeoutException] {connection.MongoClient().getAddress.getSocketAddress.toString()}
  }
}