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
        var otherTable = HashTable<Int,Int>()



        @Test
        fun put() {
            table.put(3, Pair(3,10))
            table.put(10, Pair(10,15))
            table.put(9, Pair(9,11))
            table.put(1, Pair(1,13))
            table.put(5, Pair(5,9))


            assertEquals(true, table.search(3, Pair(3, 10)))
            assertEquals(true, table.search(1, Pair(1, 13)))
            assertEquals(true, table.search(10, Pair(10, 15)))
            assertEquals(true, table.search(9, Pair(9, 11)))
            assertEquals(false, table.search(110, Pair(110, 2)))

        }

        @Test
        fun remove() {

            table.put(10, Pair(10,11))
           // table.put(7, 12)
            table.remove(10, 10)
            assertEquals(true,table.search(10,Pair(10,11)) )
            //assertEquals(0, table.remove(1))


            //val testHashTable = HashTable<Int, Int>()

            //testHashTable.put(..)
            // use put a lot of times
            // then remove and see what happens
            //test
        }

        @Test
        fun search() {
            table.put(3,Pair(3,10))
            table.put(112,Pair(112,10))
            assertEquals(true,table.search(3,Pair(3,10)))
            assertEquals(false,table.search(112,Pair(112,130)))
        }

        @Test
        fun equals() {
            otherTable.put(1, Pair(1,10))
            assertEquals(false, table == otherTable)
            assertEquals(true, table != otherTable)

        }

}