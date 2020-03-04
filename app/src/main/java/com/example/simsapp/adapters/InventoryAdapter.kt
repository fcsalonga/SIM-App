package com.example.simsapp.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.simsapp.R
import com.example.simsapp.model.Inventory
import kotlinx.android.synthetic.main.activity_main.view.*


class InventoryAdapter(private val context: Activity, private val inventories: ArrayList<Inventory>)
    : ArrayAdapter<Inventory>(context, R.layout.inventory_list, inventories){

    @SuppressLint("InflateParams", "ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.inventory_list, null, true)

        val txtDescription = rowView.findViewById<TextView>(R.id.txt_description)
        val txtTask = rowView.findViewById<TextView>(R.id.txt_task)
        val txtVersion = rowView.findViewById<TextView>(R.id.txt_version)

        txtDescription.text = inventories[position].description
        txtTask.text = inventories[position].task.toString()
        txtVersion.text = inventories[position].version.toString()

        return rowView

    }
}