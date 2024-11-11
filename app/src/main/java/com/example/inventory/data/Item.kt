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

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity data class represents a single row in the database.
 */
@Entity(tableName = "items")
/* Kelas Item sebagai Entity Room. Nama tabelnya adalah "items". */

data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    /* Menandai id sebagai PrimaryKey dengan autoGenerate = true, yang berarti Room akan menambahkan nilai ID secara otomatis. */

    val name: String,
    val price: Double,
    val quantity: Int
    /* Mendeklarasikan kolom lainnya: name untuk nama item, price untuk harga, dan quantity untuk jumlah item. */
)
