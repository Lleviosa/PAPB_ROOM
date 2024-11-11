/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1, exportSchema = false)
/* Menandai kelas ini sebagai database Room dengan menentukan entity yang digunakan (Item)
dan versi database (versi 1), lalu exportSchema ditetapkan false untuk menghindari pembuatan file skema. */

abstract class InventoryDatabase : RoomDatabase() {
/* Mendeklarasikan kelas InventoryDatabase yang merupakan subclass dari RoomDatabase.
Kelas ini adalah database utama yang mengelola penyimpanan data. */

    abstract fun itemDao(): ItemDao
    /* Mendeklarasikan fungsi abstrak itemDao() yang mengembalikan instance ItemDao. DAO ini akan digunakan untuk akses data di aplikasi. */

    companion object {
        @Volatile
        private var Instance: InventoryDatabase? = null
        /* Deklarasi variabel Instance sebagai @Volatile untuk memastikan semua thread mendapatkan pembaruan terbaru dari instance database. */

        fun getDatabase(context: Context): InventoryDatabase {
            /* Fungsi ini mengembalikan instance tunggal InventoryDatabase. Jika belum ada instance, maka akan dibuat. */

            return Instance ?: synchronized(this) {
                /* Mengecek apakah Instance sudah ada. Jika belum, membuat instance baru secara sinkron (thread-safe). */

                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .build().also { Instance = it }
                /* Room.databaseBuilder digunakan untuk membuat database baru bernama item_database jika Instance masih null.
                Hasilnya disimpan dalam Instance. */
            }
        }
    }
}

