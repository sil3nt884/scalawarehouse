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
  
  
  
  def createDialog(){
      val vbox = new VBox()
    val table = new TableView[CustomerOrder]()
    val productid = new TableColumn[CustomerOrder, String]("Product ID")
    productid.setCellValueFactory(new PropertyValueFactory[CustomerOrder, String]("OrderID"))
    val employeeid = new TableColumn[CustomerOrder, String]("Employee ID")
    employeeid.setCellValueFactory(new PropertyValueFactory[CustomerOrder, String]("Date"))
    val qauntity = new TableColumn[CustomerOrder, String]("Qauntity ID")
    qauntity.setCellValueFactory(new PropertyValueFactory[CustomerOrder, String]("Quantity"))
    val location = new TableColumn[CustomerOrder, String]("Location")
    location.setCellValueFactory(new PropertyValueFactory[CustomerOrder, String]("Location"))
    table.getColumns.addAll(productid, employeeid, qauntity, location)
    setSpacing(5)
    setPadding(new Insets(10, 0, 0, 10));
    getChildren().addAll(table);
    
  }
}