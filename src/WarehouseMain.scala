





import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout._
import javafx.stage.Stage
import com.QA.runner.MongoRunner
import com.QA.entities.Product
import com.QA.util.ArrayList
import com.QA.entities.Product
import com.QA.Connectors.DataConfig
import javafx.scene.control._
import com.QA.util.ActionHander
import javafx.scene.paint.Color
import com.QA.panefx.LoginPane
import com.QA.panefx.InventoryPane

/**
 * @author rluu
 */
class WarehouseMain extends Application {

  override def start(Stage: Stage) {
    Stage setTitle("Warehouse Tracking App")
    val root = new BorderPane() 
    root.setCenter(new InventoryPane().createTable())
    Stage setScene(new Scene(root, 300, 300))
    Stage show()
    new LoginPane("Login window")
  }
}



object WarehouseMain extends App {
  override def main(args: Array[String]) {
    Application launch(classOf[WarehouseMain], args: _*)

  }
}