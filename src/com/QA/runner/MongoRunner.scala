package com.QA.runner
import com.QA.implementatons.Mongoimpl
import com.QA.Connectors.DataConfig
import com.QA.util.ArrayList
import com.QA.entities.Product
import com.mongodb.Block
import org.bson.Document
import com.QA.util.ArrayList
import com.QA.entities.Entity
import scala.util.control.Breaks._
import java.util.HashSet
import java.util.HashMap
import com.QA.entities.Entity


/**
 * @author rluu
 */
trait MongoRunner extends Mongoimpl {
  
  /**
   * Finds everything from one collection
   */

  def findAll(obj: Any): ArrayList = {
    val list = new ArrayList()
    val test = mongo.getCollection(obj.getClass().getSimpleName).find()
    test.forEach(new Block[Document]() {
      override def apply(document: Document) {
        println(document)
        list.add(document)
      }
    })
    list
  }
  
  /**
   * Takes in an entity and then gets the 
   * feilds of the field and adds them
   * into the mongo Database
   *  
   */

  def insert(obj: Any) {
    val map = new HashMap[String, Object];
    val map2 = new HashMap[String, Object]
    val methods = obj.getClass().getDeclaredMethods
    map.put(obj.getClass().getSimpleName.toString(), obj.getClass().getSimpleName)
    for (i <- 0 until methods.size) {
      map.put(methods(i).getName.split("get")(1), methods(i).invoke(obj))
    }
    map2.putAll(map)
    mongo.getCollection(obj.getClass().getSimpleName).insertOne(new Document(map2))

  }
  
  /**
   * Updates the mongo Database  via feild 
   */

  def update(id: Integer, obj: Any, feild: String, value : String) {
    val list = findAll(obj)
    var ids : Int = 0 
    breakable {
      for (i <- 0 until list.size()) {
        list.get(i) match {
          case data: Document =>
            if (data.getInteger("ID") == id) {
              ids = data.getInteger("ID")
              break
            }
          case _ => 
        }

      }
      
    }
    mongo.getCollection(obj.getClass().getSimpleName).updateMany(new Document("ID", ids), new Document("$set", new Document(feild,value)))
  }

  def delete(id: Integer) {

  }

}