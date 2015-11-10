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

/**
 * @author rluu
 */
class CustomerOrderPane extends VBox {
  
  
  
  
  def createDialog(){
      val vbox = new VBox()
    val table = new TableView[Inventory]()
    val productid = new TableColumn[Inventory, String]("Product ID")
    productid.setCellValueFactory(new PropertyValueFactory[Inventory, String]("ProductID"))
    val employeeid = new TableColumn[Inventory, String]("Employee ID")
    employeeid.setCellValueFactory(new PropertyValueFactory[Inventory, String]("EmployeeID"))
    val qauntity = new TableColumn[Inventory, String]("Qauntity ID")
    qauntity.setCellValueFactory(new PropertyValueFactory[Inventory, String]("Quantity"))
    val location = new TableColumn[Inventory, String]("Location")
    location.setCellValueFactory(new PropertyValueFactory[Inventory, String]("Location"))
    table.getColumns.addAll(productid, employeeid, qauntity, location)
    setSpacing(5)
    setPadding(new Insets(10, 0, 0, 10));
    getChildren().addAll(table);
    
  }
}