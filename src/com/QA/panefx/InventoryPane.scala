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
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.cell.PropertyValueFactory
import com.QA.Handlers.InventoryHandler
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent


/**
 * @author rluu
 */

class InventoryPane(tab: TabPane) extends VBox with SQLRunner {
  val list = new ArrayList()
  val loadThread = new MethodThread(load)
  loadThread.start()
  loadThread.stopThread()

  createTable()

  /**
   * Creates and populates the table with
   * data
   */

  def createTable() {

    val data = FXCollections.observableArrayList[Inventory]()
    val arraylist = list.toJavaArrayList()

    listLenght(0, list)

    def listLenght(i: Integer, list: ArrayList) {
      if (i < list.size()) {
        list.get(i) match {
          case line: Inventory =>
            data.add(line)
          case _ =>
        }

        listLenght(i.+(1), list)
      }
    }

    val vbox = new VBox()
    val table = new TableView[Inventory]()
    val label = new Label("Inventory")
    val add = new Button("Add Product")
    val handle = new InventoryHandler(tab)
    add.setOnAction(handle)
    val productid = new TableColumn[Inventory, String]("Product ID")
    productid.setCellValueFactory(new PropertyValueFactory[Inventory, String]("ProductID"))
    val employeeid = new TableColumn[Inventory, String]("Employee ID")
    employeeid.setCellValueFactory(new PropertyValueFactory[Inventory, String]("EmployeeID"))
    val qauntity = new TableColumn[Inventory, String]("Qauntity ID")
    qauntity.setCellValueFactory(new PropertyValueFactory[Inventory, String]("Quantity"))
    val location = new TableColumn[Inventory, String]("Location")
    location.setCellValueFactory(new PropertyValueFactory[Inventory, String]("Location"))
    table.setItems(data)
    table.setOnMouseClicked(new EventHandler[MouseEvent]() {

      def handle(mouse: MouseEvent) {
        if (mouse.getClickCount == 2) {
          val quantity = new TextInputDialog()
          quantity.setTitle("how many?")
          val result = quantity.showAndWait()
          removeItems(result.get.toInt, table)
        val tabs = new Tab("Iventory")
        tabs.setContent(new InventoryPane(tab))
        tabs.setClosable(false)
        tab.getTabs.add(0, tabs)
        }
      }
      /**
       * Removes a set quantity of items for the database
       */

      def removeItems(i: Int, table: TableView[Inventory]) {
        updateSQL("Update inventory set quantity=quantity-"+i+" where product_id=" + table.getSelectionModel.getSelectedItem.getProductID)
      }
    })
    table.getColumns.addAll(productid, employeeid, qauntity, location)
    setSpacing(5)
    setPadding(new Insets(10, 0, 0, 10));
    getChildren().addAll(label, table, add);

  }

  /**
   * Loads from the database
   */

  def load() {
    val runner = new SQLRunner() {
      val result = findAllSQL("Select * from inventory")
      checkDatabase(result.next(), result)
      def checkDatabase(check: Boolean, rs: ResultSet) {
        if (check) {
          list.add(new Inventory(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5)))
          checkDatabase(rs.next(), rs)
        }
      }
    }

  }

}