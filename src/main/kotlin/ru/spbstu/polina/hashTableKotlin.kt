package ru.spbstu.polina

import java.util.*
import java.util.Comparator


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
        val c = arrayList.indexOfFirst { it.key == key }
        if (-1 == c) {

            arrayList.add(elToAdd)
            size++

        } else {

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

    override fun equals(other: Any?): Boolean {


        if (other is HashTable<*, *> && this.size == other.size) {
            for (i in 0 until this.size) {
                val a = this.table[i] //buck 1
                val a2 = other.table[i] //buck 2
                if (a.isNullOrEmpty() != a2.isNullOrEmpty()) return false
                else {
                    if (!a.isNullOrEmpty()) {//if not empty then
                        for (j in a) {
                            val sortedItems = a.sortedBy { it.item == j.item }

                              for (j2 in a2) {
                                val sortedItems2 = a2.sortedBy { it.item == j2.item }
                                return sortedItems == sortedItems2
                            }
                        }
                    }
                }

            }
            return true
        } else return false
    }


    override fun hashCode(): Int {
        var res = 0
        for (i in 0 until this.size) {
            if (!table[i].isNullOrEmpty()) {
                res += i * table.sumBy { it.hashCode() }

            }
        }
        return res
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