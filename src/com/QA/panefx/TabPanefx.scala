package com.QA.panefx
 import javafx.scene.control.Tab;
import javafx.scene.control.TabPane
import javafx.scene.layout.HBox
import javafx.scene.layout.BorderPane

/**
 * @author rluu
 */
class TabPanefx  extends BorderPane {
  
  createTabPane()
  
  def createTabPane() {
    
    val tabPane = new TabPane();  
    val tabIvent = new Tab("Inventory")
    val tabCustomer = new Tab("Customer Order")
    tabCustomer.setContent(new CustomerOrderPane(tabPane))
    tabCustomer.setClosable(false)
    tabIvent.setContent(new InventoryPane(tabPane))
    tabIvent.setClosable(false)
    setCenter(tabPane)
    tabPane.getTabs.addAll(tabIvent,tabCustomer)

  }
}