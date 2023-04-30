package com.example.testapp.json

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.UserData
import com.example.testapp.databinding.JsondataBinding

class AdapterJSON() : RecyclerView.Adapter<AdapterJSON.MyviewHolder>() {

    var userdatalist: List<UserData> = ArrayList()

    constructor(list: ArrayList<UserData>) : this() {
        userdatalist = list
    }

    fun setUserList(list: ArrayList<UserData>) {
        userdatalist = list
    }

    class MyviewHolder(itemView: JsondataBinding) : RecyclerView.ViewHolder(itemView.root) {
        var view: View = itemView.root
        var id = view.findViewById<TextView>(R.id.Id)
        var Title = view.findViewById<TextView>(R.id.Title)
        var userdesc = view.findViewById<TextView>(R.id.userdesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val bind = DataBindingUtil.inflate<JsondataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.jsondata,
            parent,
            false
        )
        return MyviewHolder(bind)
        //TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return userdatalist.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.id.text = userdatalist.get(position).id.toString()
        holder.Title.text = userdatalist.get(position).title
        holder.userdesc.text = userdatalist.get(position).body
    }
}