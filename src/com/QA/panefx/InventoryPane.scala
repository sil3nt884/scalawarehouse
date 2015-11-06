package com.QA.panefx
import javafx.scene.control.TableView
import javafx.scene.control._
import javafx.scene.layout.VBox
import javafx.geometry.Insets

/**
 * @author rluu
 */

class InventoryPane {

  
  def createTable() = {
    val vbox = new VBox()
    val table  = new TableView ()
    val label = new Label("Inventory")
    val productid = new TableColumn("Product ID")
    val employeeid = new TableColumn("Employee ID")
    val qauntity = new TableColumn("Qauntity ID")
    val location = new TableColumn("Location")
    table.getColumns.addAll(productid,employeeid,qauntity,location)
    vbox.setSpacing(5)
    vbox.setPadding(new Insets(10, 0, 0, 10));
    vbox.getChildren().addAll(label, table);
    vbox
  }
  
}