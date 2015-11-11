package com.QA.panefx
import javafx.scene.control.TableView
import javafx.scene.control._
import javafx.scene.layout.VBox
import javafx.geometry.Insets
import com.QA.util.MethodThread
import com.QA.runner.SQLRunner
import java.sql.ResultSet
import com.QA.util.ArrayList
import com.QA.entities.Inventory
import javafx.collections.FXCollections
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.cell.PropertyValueFactory
import com.QA.Handlers.InventoryHandler
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue
import com.QA.entities.CustomerOrder

/**
 * @author rluu
 */
class CustomerOrderPane extends VBox {
  //ID : Integer , productID : Integer, date : Date , quantity : Integer
 
  val list = new ArrayList()
  val loadThread = new MethodThread(load)
  loadThread.start()
  loadThread.stopThread()
  
  
  def createDialog(){
     val data = FXCollections.observableArrayList[CustomerOrder]()
    val arraylist = list.toJavaArrayList()

    for (i <- 0 until arraylist.size()) {
      arraylist.get(i) match {
        case line: CustomerOrder =>
          data.add(line)
        case _ =>
      }
    }
    
    val vbox = new VBox()
    val table = new TableView[CustomerOrder]()
    val orderid = new TableColumn[CustomerOrder, String]("Product ID")
    orderid.setCellValueFactory(new PropertyValueFactory[CustomerOrder, String]("OrderID"))
    val date = new TableColumn[CustomerOrder, String]("Employee ID")
    date.setCellValueFactory(new PropertyValueFactory[CustomerOrder, String]("Date"))
    val qauntity = new TableColumn[CustomerOrder, String]("Qauntity ID")
    qauntity.setCellValueFactory(new PropertyValueFactory[CustomerOrder, String]("Quantity"))
    val status = new TableColumn[CustomerOrder, String]("Location")
    status.setCellValueFactory(new PropertyValueFactory[CustomerOrder, String]("Status"))
    table.setItems(data)
    table.getColumns.addAll(orderid, date, qauntity, status)
   
    setSpacing(5)
    setPadding(new Insets(10, 0, 0, 10));
    getChildren().addAll(table);
    
  }
  
  
   def load() {
    val runner = new SQLRunner() {
      val result = findAllSQL("Select * from list")
      checkDatabase(result.next(), result)
      def checkDatabase(check: Boolean, rs: ResultSet) {
        if (check) {
          list.add(new Inventory(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4))
          )
          checkDatabase(rs.next(), rs)
        }
      }
    }

  }
}