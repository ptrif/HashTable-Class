package ru.spbstu.polina

import java.util.*


//initialCapacity == начальная емкость
data class Pair<Key, T>(val key: Key, val item: Int) //key&value pair


class HashTable<Key, T> {//or Any? uhm.. inline for what???

    private val length = 16                       //full length of the table, guess it's standard
    var size = 0                                 // count how many pairs do we have not sure if i even need it
    private val table = Array<ArrayList<Pair<Key, T>>>(length) {
        //init
        ArrayList<Pair<Key, T>>(0)
    }
    //table to arrayList
    private val indexesRange = table.indices


    /*
    puts(inserts) an element in to the HashTable
    if find - replace
    add or replace
    indexOf - look for it
    */

    fun put(key: Key, element: Pair<Key, T>) {
        val index = hash(key)
        val arrayList = table[index]

        if (arrayList.indexOf(element) == -1) {
            arrayList += element
        } else {
            for (el in arrayList)
                arrayList[index] = element
        }

        size++

    }


    /* its strange
       in theory this one is better, but in fact i dont understand how to write it properly
       properly = return an Int, not a null
     delete by given key
     defaultReturn is what it will return if it fails

     fun remove(key: Key): Int? {
         val index = hash(key)
         val iter = table[index].iterator()
        while (iter.hasNext()) {
             val pair1 = iter.next()
             if (pair1.key == key){
             iter.remove()
             println(pair1.item)
             return pair1.item
         }
        }
      return null
     }*/

    /*
    remove method
    based on boolean
    remove method works on keys
    kToRemove = given key that needs to be removed
    success == true
    fail == false
*/
    fun remove(key: Key, kToRemove: Key) {
        val index = hash(key)
        val arrayList = table[index]
        for (element in arrayList)
            if (arrayList.indexOf(element) == kToRemove)
                arrayList.remove(element)

    }


    fun search(key: Key, element: Pair<Key, T>): Boolean {
        val index = hash(key)

        val arrayList = table[index]

        return arrayList.contains(element)
    }

    /*
    compare two HashTables
    hashtable1.equals(hashtable2)
    */
    fun equals(otherTable: ArrayList<Pair<Key, T>>): Boolean =
        table == otherTable


    /*
      hashObject of Int using hashcode() fun
      I  think it's kinda OK...not great but it works
     */
    private fun hash(obj: Key): Int {

        if (obj == null) return -1 //nope to null value

        val intObject = obj.hashCode()

        return intObject % length //return hash
    }
}