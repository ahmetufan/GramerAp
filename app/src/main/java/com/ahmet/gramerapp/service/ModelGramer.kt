package com.ahmet.gramerapp.service

data class Kategori(
    val id: String,
    val name: String
)

data class KategoriModel(
    val kategori: List<Kategori>
)


data class TestModel(
    val test: List<Test>
)
data class Test(
    val id: String,
    val kategori_id: String,
    val test_name: String
)
