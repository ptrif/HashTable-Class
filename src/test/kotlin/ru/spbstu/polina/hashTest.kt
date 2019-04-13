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
    var table1 = HashTable<Int,Int>()
    var table2 = HashTable<Int,Int>()


    @Test
    fun put() {
        table.put(3, 10)
        table.put(10, 15)
        table.put(9, 11)
        table.put(1, 13)
        table.put(5, 9)
        table.put(4,28)

        assertEquals(true, table.search(3, 10))
        assertEquals(true, table.search(1,  13))
        assertEquals(true, table.search(10,  15))
        assertEquals(true, table.search(9,  11))
        assertEquals(false, table.search(110,  2))

        table.put (5, 16)
        assertEquals(true, table.search(5,  16))

    }

    @Test
    fun remove() {


        // table.put(7, 12)
        table.put(10, 11)
        table.remove(10, 10)
        table.put(7,12)
        table.put(8,19)
        table.remove(8,19)
        table.put(3,10)
        table.remove(3,10)
        table.remove(4,28)

        assertEquals(true, table.search(10,  11))
        assertEquals(true, table.search(7, 12))
        assertEquals(false, table.search(8,19)) //no el => search gives FALSE=> el was removed
        assertEquals(false, table.search(3,10))
        assertEquals(false,table.search(4,28))


        //val testHashTable = HashTable<Int, Int>()

        //testHashTable.put(..)
        // use put a lot of times
        // then remove and see what happens
        //test
    }

    @Test
    fun search() {
        table.put(3, 10)
        table.put(112,  10)
        table.put(8,19)
        table.remove(8,19)
        assertEquals(true, table.search(3, 10))
        assertEquals(false, table.search(112, 113))
        assertEquals(false, table.search(8,19))
        table.remove(3,10)
        assertEquals(false, table.search(3,10))
    }

    @Test
    fun equals() {
        table.put(3,10)
        table.put(4,28)
        otherTable.put(1, 10)
        otherTable.put(14,15)
        assertEquals(false, table == otherTable)
        assertEquals(true, table != otherTable)

        table1.put(1,1)
        table2.put(1,1)
        assertEquals(true, table1.equals(table2)) //doesnt work as expected

    }

}