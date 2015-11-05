package com.QA.implementatons
import com.mongodb.Block
import org.bson.Document
import com.QA.Connectors.DataConfig
import org.bson.Document
import com.QA.util.ArrayList

/**
 * @author rluu
 */

trait Mongoimpl {
  
  val mongo = new DataConfig().MongoClient().getDatabase("mydb")

    def insert(obj :Any) 
    def findAll(ojb : Any) : ArrayList
    def delete(id : Integer)
    def update(id: Integer)
}