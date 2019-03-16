package ru.spbstu.polina

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class HashTableTest {

    // do hashtable
// i think i didn't get it right from the practice
    private val table = hashMapOf(0 to 1, 1 to 2, 2 to 3, 3 to 4, 4 to 5)
    private val otherTable = hashMapOf(0 to 5, 1 to 4, 2 to 3, 3 to 2, 4 to 1)


    @Test
    fun put() {
        table.put(3, 10)
        table.put(10, 15)
        table.put(9, 11)
        table.put(1, 13)
        table.put(5, 9)


        assertEquals(10, table.get(3))
        assertEquals(13, table.get(1))
        assertEquals(15, table.get(10))
        assertEquals(11, table.get(9))
        assertEquals(null, table.get(110))

    }

    @Test
    fun remove() { /*if el didn't exist in the original table and you want to remove it
                    first you need to PUT it in the fun*/

        table.put(10, 11)
        table.put(7, 12)
        assertFalse(table.remove(5,9))
        assertTrue(table.remove(0,1))
        assertTrue(table.remove(7,12))

        //val testHashTable = HashTable<Int, Int>()

        //testHashTable.put(..)
        // use put a lot of times
        // then remove and see what happens
        //test
    }

    @Test
    fun get() {
        val v = 3
        assertEquals(true, table[v] == table.get(3) )
    }

    @Test
    fun equals() {
        assertEquals(false, table == otherTable)
        assertEquals(true, table != otherTable)
    }
}