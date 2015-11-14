




import scalafx.Includes._
import javafx.application.Application
import scalafx.scene.Scene
import scalafx.scene.layout._
import javafx.stage.Stage
import com.QA.runner.MongoRunner
import com.QA.entities.Product
import com.QA.util.ArrayList
import com.QA.entities.Product
import com.QA.Connectors.DataConfig
import scalafx.scene.control._
import com.QA.util.ActionHander
import scalafx.scene.paint.Color
import com.QA.panefx.LoginPane
import com.QA.panefx.InventoryPane
import com.QA.panefx.TabPanefx
import java.util.logging.Logger
import java.util.logging.Level


/**
 * @author rluu
 */
class WarehouseMain extends Application {

  override def start(Stage: Stage) {
    Stage setTitle("Warehouse Tracking App")
    val root = new BorderPane() 
    root.setCenter(new TabPanefx())
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