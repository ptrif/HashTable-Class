package ru.spbstu.polina

import java.util.*

data class Pair<Key, T>(val key: Key, var item: T)

class HashTable<Key, T> {
    private var length = 16
    var size = 0
    private val table = Array<ArrayList<Pair<Key, T>>>(length) {
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

    /*
    looks for el in arrayList by given key
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

    /*
    compare two HashTables
    */
    override fun equals(other: Any?): Boolean {
        var res = false
        if (other is HashTable<*, *> && this.size == other.size) {
            for (i in 0 until this.size) {
                val bucket = table[i].toTypedArray()
                val otherBucket = other.table[i].toTypedArray()

                if (!bucket.isNullOrEmpty()) {
                    res = bucket contentDeepEquals  otherBucket
                }
            }
        }
        return res
    }

    /*
     hashCode for equals
    */
    override fun hashCode(): Int {
        var res = 0
        for (i in 0 until this.size) {
            if (!table[i].isNullOrEmpty()) {
                res += i * table[i].sumBy { it.hashCode() }
            }
        }
        return res
    }

    /*
    hashObject of Int
    for indexes obviously
    */
    private fun hash(obj: Key): Int {
        if (obj == null) return -1
        val intObject = obj.hashCode()
        return intObject % length
    }

}