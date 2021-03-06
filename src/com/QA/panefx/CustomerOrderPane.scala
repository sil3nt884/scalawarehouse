package com.QA.panefx
import javafx.scene.control.TableView
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
import javafx.event._
import javafx.scene.input._
import javafx.scene.control._
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane
import javafx.scene.layout.HBox
import javafx.scene.layout.BorderPane
import com.QA.Handlers.CustomerOrderHandler


/**
 * @author rluu
 */
class CustomerOrderPane(tab: TabPane) extends VBox with SQLRunner{

  val list = new ArrayList()
  val loadThread = new MethodThread(load)
  loadThread.start()
  loadThread.stopThread()

  createTable()

  /**
   * Creates customerOredr Table
   */

  def createTable() {
    val data = FXCollections.observableArrayList[CustomerOrder]()
    val arraylist = list.toJavaArrayList()
    
    listLenght(0,list)
    def listLenght(i: Integer, list: ArrayList) {
    if (i < list.size()) {
    list.get(i) match {
        case line: CustomerOrder =>
          data.add(line)
        case _ =>
      }
    
      listLenght(i.+(1), list)
    }
  }
    


    val vbox = new VBox()
    val table = new TableView[CustomerOrder]()
    val customerid = new TableColumn[CustomerOrder, String]("CustomerID")
    customerid.setCellValueFactory(new PropertyValueFactory[CustomerOrder, String]("CustomerID"))
    val employeeid = new TableColumn[CustomerOrder, String]("EmployeeID")
    employeeid.setCellValueFactory(new PropertyValueFactory[CustomerOrder, String]("EmployeeID"))
    val orderid = new TableColumn[CustomerOrder, String]("OrderID")
    orderid.setCellValueFactory(new PropertyValueFactory[CustomerOrder, String]("OrderID"))
    val product = new TableColumn[CustomerOrder, String]("Product ID")
    product.setCellValueFactory(new PropertyValueFactory[CustomerOrder, String]("ProductID"))
    val date = new TableColumn[CustomerOrder, String]("Date")
    date.setCellValueFactory(new PropertyValueFactory[CustomerOrder, String]("Date"))
    val qauntity = new TableColumn[CustomerOrder, String]("Qauntity")
    qauntity.setCellValueFactory(new PropertyValueFactory[CustomerOrder, String]("Quantity"))
    val status = new TableColumn[CustomerOrder, String]("Status")
    status.setCellValueFactory(new PropertyValueFactory[CustomerOrder, String]("Status"))
    table.setItems(data)
    table.setOnMouseClicked(new CustomerOrderHandler (tab,table))
    table.getColumns.addAll(customerid, employeeid, orderid, product, date, qauntity, status)
    setSpacing(5)
    setPadding(new Insets(10, 0, 0, 10));
    getChildren().addAll(table);

  }

  /**
   * Loads from database
   */

  def load() {
    val runner = new SQLRunner() {
      val result = findAllSQL("Select * from list")
      checkDatabase(result.next(), result)
      def checkDatabase(check: Boolean, rs: ResultSet) {
        if (check) {
          println(rs.getInt(1), rs.getInt(2) ,rs.getInt(5), rs.getInt(6), rs.getString(3), rs.getInt(7), rs.getInt(4))
          list.add(new CustomerOrder(rs.getInt(1), rs.getInt(2) ,rs.getInt(5), rs.getInt(6), rs.getString(3), rs.getInt(7), rs.getInt(4)))
          checkDatabase(rs.next(), rs)
        }
      }
    }

  }
}