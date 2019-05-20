package ru.spbstu.polina

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class HashTableTest {

    // do hashtable

    // private val table = hashMapOf(0 to 1, 1 to 2, 2 to 3, 3 to 4, 4 to 5)
    // private val otherTable = hashMapOf(0 to 5, 1 to 4, 2 to 3, 3 to 2, 4 to 1)
    var table = HashTable<Int, Int>()
    var otherTable = HashTable<Int, Int>()
    var table1 = HashTable<Int, Int>()
    var table2 = HashTable<Int, Int>()
    private val tab = null
    private val tab1 = null


    @Test
    fun put() {
        table.put(3, 10)
        table.put(10, 15)
        table.put(9, 11)
        table.put(1, 13)
        table.put(5, 9)
        table.put(4, 28)
        table.put(4, 29)
        assertEquals(10, table.search(3))

        assertEquals(13, table.search(1))
        assertEquals(29, table.search(4))
        assertEquals(null, table.search(34))

    }

    @Test
    fun remove() {


        // table.put(7, 12)
        table.put(10, 11)
        table.remove(10)
        table.put(7, 12)
        table.put(8, 19)
        table.remove(8)
        table.put(3, 10)
        table.remove(3)
        table.remove(4)
        assertEquals(null, table.search(10))
        assertEquals(12, table.search(7))
        table.remove(7)
        assertEquals(null, table.search(7))


        //val testHashTable = HashTable<Int, Int>()

        //testHashTable.put(..)
        // use put a lot of times
        // then remove and see what happens
        //test
    }

    @Test
    fun search() {
        table.put(3, 10)
        table.put(112, 10)
        table.put(8, 19)
        table.remove(8)
        assertEquals(10, table.search(3))

    }

    @Test
    fun equals() {
        table.put(3, 10)
        table.put(4, 28)
        otherTable.put(1, 10)
        otherTable.put(14, 15)
        assertEquals(false, table == otherTable)
        assertEquals(true, table != otherTable)

        table1
        table2
        assertEquals(true, table1 == table2)
        assertEquals(true, tab == tab1)

        val oth = Pair(3,6)

        assertEquals(false, oth == table)


    }

}