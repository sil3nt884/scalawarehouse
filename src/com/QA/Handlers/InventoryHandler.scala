package com.QA.Handlers
import com.QA.util.ActionHander
import javafx.event._
import com.QA.entities.Product
import javafx.stage._
import javafx.collections._
import javafx.scene.control._
import javafx.scene.layout.StackPane
import javafx.scene._
import javafx.scene.layout.VBox
import org.bson.Document
import com.QA.util.Session
import com.QA.panefx.InventoryPane


/**
 * @author rluu
 */
class InventoryHandler(tab: TabPane ) extends ActionHander {

  val productdata = FXCollections.observableArrayList[Int]()
  val productlist = findAll(new Product())
  for (i <- 0 until productlist.size()) {
    productlist.get(i) match {
      case line: Document =>
        productdata.add(line.getInteger("ID"))
      case _ =>
    }

  }
  val stage = new Stage()
  val box = new VBox()
  val comblb = new Label("product id")
  val comboBox = new ComboBox(productdata)
  comboBox.setOnAction(this)
  val quantitylb = new Label("Quanitiy")
  val quanity = new TextField()
  val root = new StackPane()
  var name = "unknown"
  val namelb = new Label("Product name: " + name)

  val ok = new Button("Add")
  ok.setOnAction(this)
  val locationlb = new Label("Location")
  val location = new TextField()
  var id: Int = 0
  var price: Int = 0;
  
  def handle(event: ActionEvent) {
    val list = findAll(new Product())
    event.getSource match {
      case data: Button =>
        if (data.getText.equalsIgnoreCase("Add Product")) {
          createDialog()
        }
        if (data.getText.equalsIgnoreCase("Add")) {
          println("adding")
          if (id != 0) {
            for (i <- 0 until list.size()) {
              list.get(i) match {
                case doc: Document =>
                  if (doc.getInteger("ID") == id) {
                    price = doc.getInteger("Price")
                  }
              }
            }
            addProduct(new Product(id, name, price), quanity.getText, location.getText)
          }

        }

      case comboBox: ComboBox[Integer] =>
        val value = comboBox.getSelectionModel.getSelectedItem.intValue()
        id = value
        println(id)
        for (i <- 0 until list.size()) {
          list.get(i) match {
            case doc: Document =>
              if (doc.getInteger("ID") == value) {
                name = doc.getString("Name")
                namelb.setText("Product name: " + name)
              }
          }
        }
      case _ =>

    }

  }
  /**
   * shows Product Dialog
   */

  def createDialog() {
    box.getChildren.addAll(comblb, comboBox, quantitylb, quanity, namelb, locationlb, location, ok)
    root.getChildren.addAll(box)
    stage.setScene(new Scene(root, 200, 200))
    stage.show()

  }

  def addProduct(product: Product, quantity: String, location: String) {
    if (location.length() <= 2) {
      insertSQL("Insert into Inventory values(" + product.getID() + "," + Session.getSession() + "," + quantity + "," + "'"+location+"'" + ");")
       tab.getTabs.remove(0)
       val tabs = new Tab ("Inventory")
       tabs.setContent( new InventoryPane(tab))
       tabs.setClosable(false)
       tab.getTabs.add(0, tabs)
       
    } else {
      System.err.println("invliad location")
    }
  }

}