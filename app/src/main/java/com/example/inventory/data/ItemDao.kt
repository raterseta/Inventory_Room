package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
* @Dao adalah anotasi interface
* @Insert untuk menambahkan data
* biasanya saat menambahkan atau menyisipkan data, akan terjadi konflik
* Untuk Menghindari konflik, kita menggunaan (onConflict = OnConflictStrategy.IGNORE)
*
* Suspend ada karena agar dijalankan oleh Courutine
*
* @Delete untuk menghapus data
*
* @Queri adalah untuk menjalankan queri
* */

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>
}