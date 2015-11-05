package com.QA.runner
import com.QA.implementatons.Mongoimpl
import com.QA.Connectors.DataConfig
import com.QA.util.ArrayList
import com.QA.entities.Product
import com.mongodb.Block
import org.bson.Document
import com.QA.util.ArrayList

import java.util.HashSet
import java.util.HashMap

/**
 * @author rluu
 */
class MongoRunner extends Mongoimpl {
 


  def findAll(obj: Any) : ArrayList ={
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

  def insert(obj: Any) {
    val map = new HashMap[String, Object];
    val map2 = new HashMap[String, Object]
    val methods = obj.getClass().getDeclaredMethods
    map.put(obj.getClass().getSimpleName.toString(), obj.getClass().getSimpleName)
    for(i <- 0 until methods.size){
     map.put(methods(i).getName.split("get")(1), methods(i).invoke(obj))
    }
    map2.putAll(map)
    mongo.getCollection(obj.getClass().getSimpleName).insertOne(new Document(map2))
     
  }

  def update(id: Integer) {

  }

  def delete(id: Integer) {

  }

}