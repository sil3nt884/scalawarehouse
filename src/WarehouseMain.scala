





import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.StackPane
import javafx.stage.Stage
import com.QA.runner.MongoRunner
import com.QA.entities.Product
import com.QA.util.ArrayList
import com.QA.entities.Product
import com.QA.Connectors.DataConfig
import javafx.scene.control._
import com.QA.util.ActionHander
/**
 * @author rluu
 */
class WarehouseMain extends Application {

  override def start(Stage: Stage) {
    Stage setTitle("Warehouse Tracking App")
    val root = new StackPane
    val button = new Button("Create user")
    button.setOnAction(new ActionHander())
    root.getChildren.add(button)
    Stage setScene(new Scene(root, 300, 300))
    Stage show()
  }
}

object WarehouseMain extends App {
  override def main(args: Array[String]) {
    Application launch(classOf[WarehouseMain], args: _*)

  }
}