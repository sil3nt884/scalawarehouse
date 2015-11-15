

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
import java.io.File
import com.QA.runner.SQLRunner
import java.io.FileReader
import java.nio.file.Paths
import java.nio.file.Files
import javax.swing.JOptionPane
import java.nio.file.StandardCopyOption

/**
 * @author rluu
 */
class WarehouseMain extends Application with SQLRunner {

  override def start(Stage: Stage) {
    createDatabases()
    Stage setTitle ("Warehouse Tracking App")
    val root = new BorderPane()
    root.setCenter(new TabPanefx())
    Stage setScene (new Scene(root, 300, 300))
    Stage show ()
    new LoginPane("Login window")
  
  }
  
  /**
   * Creates the database needed 
   * to runthis program
   */

  def createDatabases() : Boolean = {
   val mongo = new File("C:/data")
   if(mongo.exists()==false){
   val option = JOptionPane.showConfirmDialog(null, "This program will create new files on\nyour hard drive do you want to continue? it will replace anything in C:/data")
     if(option==1){
       JOptionPane.showMessageDialog(null, "Please manually install files\ncopy data into C:/ and excute the SQL file")
       System.exit(0)
     }
   
   if(option==0){
 
    if (!(System.getProperty("java.version").contains("1.8"))) {
      JOptionPane.showMessageDialog(null, "Java 8 needed")
      System.exit(0)
    }
    val mongo = new File("C:/data")
    if (!mongo.exists()) {
      Files.copy(Paths.get("data"), Paths.get("C:/"), StandardCopyOption.REPLACE_EXISTING)
    }
    val content = new String(Files.readAllBytes(Paths.get("Dump20151115-1.sql")))
    val statements = content.split(";")
   
    runstatemtns(0, statements)
    def runstatemtns (i : Int , stats : Array[String]){
      if(i < stats.length){
        
        this.updateSQL(stats(i))
        
        runstatemtns(i.+(1), statements)
      }
    }
    
   }
   }
   true
  }
  
}

object WarehouseMain extends App {
  override def main(args: Array[String]) {
    Application launch (classOf[WarehouseMain], args: _*)

  }
}