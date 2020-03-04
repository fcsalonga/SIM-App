package com.example.simsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.simsapp.adapters.InventoryAdapter
import com.example.simsapp.model.Inventory
import com.github.kittinunf.fuel.Fuel
import org.json.JSONObject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val inventories = arrayListOf<Inventory>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            Fuel.get("http://<IP ADDRESS>/test")
            .responseString { request, response, result ->

                val objInvt =  JSONObject(result.get())

                val val2 = objInvt.getJSONArray("users")

                val inventory: Inventory

                for(i in 0 until val2.length()){

                    val list = val2.getJSONObject(i)

                        inventories.add(Inventory(list.getInt("id"), list.getString("description"),list.getInt("task"),
                            list.getDouble("version")))
                }

               val mListView = inventory_list
                val myListAdapter = InventoryAdapter(this, inventories)
                mListView.adapter = myListAdapter

            }

    }
}
