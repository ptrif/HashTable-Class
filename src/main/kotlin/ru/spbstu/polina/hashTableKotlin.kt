package ru.spbstu.polina

import java.util.*



data class Pair<Key, T>(val key: Key, var item: T) //key&value pair


class HashTable<Key, T> {

    private var length = 16                       //full length of the table, guess it's standard
    var size = 0
    private val table = Array<ArrayList<Pair<Key, T>>>(length) {
        //init
        ArrayList(0)
    }


    /*
    puts(inserts) an element in to the HashTable
    if find - replace
    if not - add
    */

    fun put(key: Key, item: T) {
        val index = hash(key)
        val arrayList = table[index]
        val elToAdd = Pair(key, item)

        if (-1 == arrayList.indexOfFirst { it.key == key }) {

            arrayList.add(elToAdd)
            size++

        } else {
            val c = arrayList.indexOfFirst { it.key == key }
            arrayList[c].item = elToAdd.item
        }
    }

    /*
     removes element by given key
    */

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


    /* looks for el in arrayList by given key
       if found - returns item
       if not - returns null
    */
    fun search(key: Key): T? {
        val index = hash(key)
        val arrayList = table[index]

        return arrayList
            .firstOrNull { it.key == key }
            ?.item
    }

    //compare two HashTables

    fun equals2(otherTable: Any?): Boolean {

        return if (otherTable is HashTable<*, *> && (this.size == otherTable.size)) {
            for (i in 0 until this.size)
                when {
                    this.table[i].isNullOrEmpty() != otherTable.table[i].isNullOrEmpty() -> return false
                    else -> if (this.table.sort(0, size) != otherTable.table.sort(0, size)) return false
                }
            true
        } else false
    }

    /*
    hashObject of Int using hashcode() fun
    */
    private fun hash(obj: Key): Int {

        if (obj == null) return -1

        val intObject = obj.hashCode()

        return intObject % length //return hash
    }


}