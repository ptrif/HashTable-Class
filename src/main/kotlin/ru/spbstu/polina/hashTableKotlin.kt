package ru.spbstu.polina

import java.util.*


//initialCapacity == начальная емкость
data class Pair<Key, Int>(val key: Key, val item: Int) //key&value pair


class HashTable<Key, T> {//or Any? uhm.. inline for what???

    private var length = 16                       //full length of the table, guess it's standard
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

    fun put(key: Key, item: T) {
        val index = hash(key)
        val arrayList = table[index]
        val elToAdd = Pair(key, item)


        //arrayOf(1,2,3).indexOfFirst { it == 2 }
        if (elToAdd.key != arrayList.indexOfFirst { it == key }) {

            arrayList += elToAdd
            size++

        } else {
            arrayList[index] = elToAdd
        }

        /* if (arrayList.indexOf(elToAdd) == -1) { //indexOf - nnot help
             //предикат
                                                //айти в массиве функцию которая поможет нати по предикату
             arrayList += elToAdd
             size++
         } else {
             arrayList[index] = elToAdd

         }*/

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
    fun remove(key: Key, item: T) {
        val index = hash(key)
        val arrayList = table[index]
        val elToRemove = Pair(key, item)

        if (arrayList.indexOf(elToRemove) != -1)
            arrayList.remove(elToRemove)
        size--
/*for (element in arrayList) {
    if (arrayList.indexOf(element) == 1)
        arrayList.remove(element)
}*/

    }


    fun search(key: Key, item: T): Boolean { //look carefully
        val index = hash(key)
        val elToSearch = Pair(key, item)

        val arrayList = table[index]
        var result = false

        if (arrayList.contains(elToSearch)) result = true

        return result
    }

    /*
    compare two HashTables
    hashtable1.equals(hashtable2)
    */
    fun equals(otherTable: Array<ArrayList<Pair<Key, T>>>, key: Key): Boolean { // = table == othertable
        val index = hash(key)
        val arrayList = table[index]
        val arrayList2 = otherTable[index]
        println(arrayList)
        println(arrayList2)
        var res = false
        if (arrayList.equals(arrayList2)) res = true
        return res

    }


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