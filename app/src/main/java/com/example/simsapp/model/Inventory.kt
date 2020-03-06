package com.example.simsapp.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class Inventory(
    val id:Int,
    val description:String,
    val task:Int,
    val version:Int)

