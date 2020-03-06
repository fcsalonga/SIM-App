package com.example.simsapp

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simsapp.adapters.InventoryAdapter
import com.example.simsapp.model.Inventory
import com.github.kittinunf.fuel.Fuel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.inventory_list.view.*
import org.json.JSONObject



class MainActivity : AppCompatActivity() {

    val URL = "http://172.16.10.171:8000/test"
    val inventories = arrayListOf<Inventory>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Fuel.get(URL)
            .response{ request, response, result ->

                val (bytes, error) = result
                if(bytes != null) {

                    val json  = String(response.data)
                    val jsonObject = JSONObject(json.toString())
                    val ints = jsonObject.getJSONArray("rows")
                    val inventory: Inventory
                    for (i in 0 until ints.length()){
                        val list = ints.getJSONObject(i)
                        inventories.add(Inventory(list.getInt("id"), list.getString("description"),list.getInt("task"),
                            list.getInt("version")))
                    }

                    val mListView = inventory_list
                    //append inventoy to adapter
                    val myListAdapter = InventoryAdapter(this, inventories)
                    mListView.adapter = myListAdapter
                    mListView.setOnItemClickListener { parent, view, position, id ->
                        val element = myListAdapter.getPosition(position) // The item that was clicked
                        val intent = Intent(this, detailsActivity::class.java)
                        startActivity(intent)
                    }
//                    mListView.setOnItemClickListener(OnItemClickListener { parent, view, position, id ->
//                       // val intent = Intent(applicationContext, detailsActivity::class.java)
//                        intent.putExtra("ID", mListView.txt_description.text);
//
//                        //startActivity(intent)
//                    })
                }
            }
    }



}
