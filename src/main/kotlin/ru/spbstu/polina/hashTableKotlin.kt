package ru.spbstu.polina

import java.util.*

//initialCapacity == начальная емкость
data class Pair<Key, T>(val key: Key, val item: T) //key&value pair


class HashTable<Key, T : Int> {//or Any? uhm.. inline for what???

    private val length = 16               //full length of the table, guess it's standard
    var size = 0                         // count how many pairs do we have
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

    fun put(key: Key, item: Int) {
        val index = hash(key)
        val arrayList = table[index]
        for (element in arrayList)
            if (arrayList.indexOf(element) == -1) // check if we have this element in a HashTable
                arrayList += element             // if element not found - arrayList.add(element)
            else                                // if it found - replace
                arrayList[index] = element     //arrayList.set(index, element)

        size++

    }


    /*
     delete by given key
     defaultReturn is what it will return if it fails
    */
    /* fun remove(key: Key, defaultReturn: T? = null): T? {
         val index = hash(key)
         val iter = table[index].iterator()
         while (iter.hasNext()) {
             val pair1 = iter.next()
             if (pair1.key != key) continue
             iter.remove()
             return pair1.item
         }

         return defaultReturn
     }
 */
    /*
    remove method
    based on boolean
    fun tries to remove an element from HashTable
    success == true
    fail == false
    */
    fun remove(key: Key, V: Pair<Key, T>) {// specify try to remove by ONLY given key, not the whole elToRemove
        val index = hash(key)
        val arrayList = table[index]
        val elToRemove = V
        for (element in arrayList)
            if (arrayList.indexOf(element) == arrayList.indexOf(elToRemove))
                arrayList.remove(element)
    }

    /*
     Searches for an element in HashTable by a given key
     well, maybe indexOf will save me another time
     if we have an element returns TRUE
     if not - FALSE
    */

    fun get(key: Key, v: Key) {//boolean
        val index = hash(key)
        val arrayList = table[index]
        val givenKey = hash(v)
        for (element in arrayList)
            arrayList.indexOf(element) == givenKey

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