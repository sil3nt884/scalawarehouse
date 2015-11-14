package com.QA.Handlers
import javafx.event._
import javafx.scene.input._
import javafx.scene.control._
import com.QA.entities.CustomerOrder
import com.QA.runner.SQLRunner
import com.QA.panefx.CustomerOrderPane
import com.QA.util.Session
import javax.swing.JOptionPane;
import javafx.stage._
import javafx.scene._
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import com.QA.runner.MongoRunner
import com.QA.entities.Product
import org.bson.Document
import com.QA.util.ArrayList

/**
 * @author rluu
 */
class CustomerOrderHandler(tab: TabPane, table: TableView[CustomerOrder]) extends EventHandler[MouseEvent] with SQLRunner with MongoRunner {

  def handle(mouse: MouseEvent) {
    if (mouse.getClickCount == 2) {
      val item = table.getSelectionModel.getSelectedItem
      println(item.getEmployeeID())
      if (item.getEmployeeID.equals("1") && Session.getSession() != 0 && item.getStatus.equals("1")) {
        println("updated item")
        updateDatabase("Update customerorder , orders set Status=2, EmplyoeeID=" + Session.getSession() + " Where (CustomerID=" + item.getCustomerID + " and orders.ProductID=" + item.getProductID + " and Date='" + item.getDate + "');")
        createDialog(item)
        tab.getTabs.remove(1)
        val tabs = new Tab("Customer Order")
        tabs.setContent(new CustomerOrderPane(tab))
        tabs.setClosable(false)
        tab.getTabs.add(1, tabs)
      } else {
        JOptionPane.showMessageDialog(null, "Order Already Claimed")
      }

    }

  }
  /**
   * Creats a dailog showing the
   * current product selected
   */

  def createDialog(item: CustomerOrder) {
    val dailog = new Stage()
    val root = new BorderPane()  
    val box = new VBox()
    val orderIDlb = new Label("OrderID: " + item.getOrderID())
    val customerIDlb = new Label("CustomerID " + item.getCustomerID)
    var name: String = ""

    val list = this.findAll(new Product())
    
    listLenght(0,list)
    
    def listLenght (i : Integer ,list : ArrayList)  {
      if(i < list.size()){
        list.get(i)match {
          case line: Document =>
          val id = line.getInteger("ID")
          if (item.getProductID.equals(id + "")) {
            name = line.getString("Name")
          }
        }   
        listLenght(i.+(1) , list)
      }
    }

    
    val productlb = new Label("Product : " + name)
    val quanity = new Label("Quanity : " + item.getQuantity())
    val checkOut = new Button("CheckOut")
    checkOut.setOnAction(new CheckoutHandler(Integer.parseInt(item.getProductID),item,tab))
    box.getChildren.addAll(orderIDlb, customerIDlb, productlb, quanity, checkOut)
    root.setCenter(box)
    dailog.setScene(new Scene(root, 200, 200))
    dailog.show()
  }

  def updateDatabase(statement: String) {
    updateSQL(statement)
  }

}