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

/**
 * @author rluu
 */
class CustomerOrderHandler(tab: TabPane, table: TableView[CustomerOrder]) extends EventHandler[MouseEvent] with SQLRunner {

  def handle(mouse: MouseEvent) {
    if (mouse.getClickCount == 2) {
      val item = table.getSelectionModel.getSelectedItem
      println(item.getEmployeeID())
      if (item.getEmployeeID.equals("1") && Session.getSession()!=0 && item.getStatus.equals("1")) {
        println("updated item")
        updateDatabase("Update customerorder  set Status=2, EmplyoeeID=" + Session.getSession() + " Where CustomerID=" + item.getCustomerID)
        createDialog()
        tab.getTabs.remove(1)
        val tabs = new Tab("Customer Order")
        tabs.setContent(new CustomerOrderPane(tab))
        tabs.setClosable(false)
        tab.getTabs.add(1, tabs)
      }
      else {
        JOptionPane.showMessageDialog(null, "Order Already Claimed")
      }

    }

  }

  def createDialog() {
    val dailog = new Stage()
    val root = new BorderPane()

    dailog.setScene(new Scene(root, 200, 200))
    dailog.show()
  }

  def updateDatabase(statement: String) {
    updateSQL(statement)
  }

}