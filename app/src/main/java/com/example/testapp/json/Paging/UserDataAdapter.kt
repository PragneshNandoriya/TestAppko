package com.example.testapp.json.Paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.databinding.JsondataBinding


class UserDataAdapter :
    PagingDataAdapter<UserDatawithName, UserDataAdapter.UserDataHolder>(MovieComparator) {
    var userdatalist: List<UserDatawithName> = ArrayList()


    class UserDataHolder(itemView: JsondataBinding) : RecyclerView.ViewHolder(itemView.root) {
        var view: View = itemView.root
        var id = view.findViewById<TextView>(R.id.Id)
        var Title = view.findViewById<TextView>(R.id.Title)
        var userdesc = view.findViewById<TextView>(R.id.userdesc)
    }

    override fun onBindViewHolder(holder: UserDataHolder, position: Int) {
        holder.id.text = userdatalist.get(position).id.toString()
        holder.Title.text = userdatalist.get(position).name
        holder.userdesc.text = userdatalist.get(position).body
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataHolder {
        val bind = DataBindingUtil.inflate<JsondataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.jsondata,
            parent,
            false
        )
        return UserDataHolder(bind)
    }

    object MovieComparator : DiffUtil.ItemCallback<UserDatawithName>() {
        override fun areItemsTheSame(oldItem: UserDatawithName,
                                     newItem: UserDatawithName): Boolean {
            // Id is unique.
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: UserDatawithName,
                                        newItem: UserDatawithName): Boolean {
            return oldItem == newItem
        }
    }
}