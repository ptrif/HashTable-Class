package ru.spbstu.polina

import java.util.*


//initialCapacity == начальная емкость
data class Pair<Key, T>(val key: Key, var item: T) //key&value pair


class HashTable<Key, T> {//or Any? uhm.. inline for what???

    private var length = 16                       //full length of the table, guess it's standard
    var size = 0                                 // count how many pairs do we have not sure if i even need it
    private val table = Array<ArrayList<Pair<Key, T>>>(length) {
        //init
        ArrayList(0)
    }


    /*
    puts(inserts) an element in to the HashTable
    if find - replace
    add or replace
    indexOf - look for it
    */

    fun put2(key: Key, item: T) {
        val index = hash(key)
        var arrayList = table[index]
        val elToAdd = Pair(key, item)
        for (i in arrayList.indices) {
            if (elToAdd.key == arrayList[i].key) {
                arrayList[i].item = elToAdd.item
            } else {
                arrayList.add(elToAdd)
                size++
            }

        }


    }

    fun put(key: Key, item: T) {
        val index = hash(key)
        var arrayList = table[index]
        val elToAdd = Pair(key, item)

        if (elToAdd.key == arrayList.indexOfFirst { it == key }) {
            val c = arrayList.indexOfFirst { it == key }
            arrayList[c].item = elToAdd.item

        } else {
            arrayList.add(elToAdd)
            size++
        }
    }


    fun remove(key: Key): T? {
        val index = hash(key)
        val arrayList = table[index]
        val iterator = arrayList.iterator()
        while (iterator.hasNext()) {
            val next = iterator.next()
            if (next.key == key) {
                iterator.remove()
                size--
                return next.item
            }
        }
        return null

    }


    // looks for el in arrayList by key
    fun search(key: Key): T? {
        val index = hash(key)
        val arrayList = table[index]

        return arrayList
            .firstOrNull { it.key == key }
            ?.item
    }

    /*
    compare two HashTables
    hashtable1.equals(hashtable2)
    */

    fun equals2(otherTable: Any): Boolean {
        if (otherTable is HashTable<*, *> && this.size == otherTable.size) {
            for (i in 0..this.size - 1) {
                when {
                    this.table[i].isEmpty() != otherTable.table[i].isEmpty() -> return false
                    table[i].isNotEmpty() && this.table.sort() != otherTable.table.sort() -> return false
                }
            }
            return true
        } else
            return false
    }


    /*
    hashObject of Int using hashcode() fun
    I  think it's kinda OK...not great but it works
    */
    private fun hash(obj: Key): Int {

        if (obj == null) return -1

        val intObject = obj.hashCode()

        return intObject % length //return hash
    }


}