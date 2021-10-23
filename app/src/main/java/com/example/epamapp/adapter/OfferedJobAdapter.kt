package com.example.epamapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.epamapp.R
import com.example.epamapp.data.OfferedJobItem

class OfferedJobAdapter(private val listener: OfferedJobItemClickListener) :
    RecyclerView.Adapter<OfferedJobAdapter.OfferedJobViewHolder>() {

    private val items = mutableListOf<OfferedJobItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferedJobViewHolder {
        val itemView: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_job_list, parent, false)
        return OfferedJobViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OfferedJobViewHolder, position: Int) {
        val item = items[position]
        holder.twJobItemName.text = item.name
        holder.twJobItemDescription.text = item.name
        holder.twJobItemCompany.text = item.name
        holder.twJobDate.text=item.date
        holder.twJobDate.text=item.date
        holder.twJobItemCategory.text = item.category.name

        holder.item = item
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItem(item: OfferedJobItem) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun deleteItem(item: OfferedJobItem){
        val position=items.indexOf(item)
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun update(offeredJobItems: List<OfferedJobItem>) {
        items.clear()
        items.addAll(offeredJobItems)
        notifyDataSetChanged()
    }

    interface OfferedJobItemClickListener {
        fun onItemChanged(item: OfferedJobItem)
        fun onItemDeleted(item: OfferedJobItem)
    }

    inner class OfferedJobViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val twJobItemName: TextView
        val twJobItemDescription: TextView
        val twJobItemCompany: TextView
        val twJobDate: TextView
        val twJobItemCategory: TextView

        var item: OfferedJobItem? = null

        init {
            twJobItemName = itemView.findViewById(R.id.twJobItemName)
            twJobItemDescription = itemView.findViewById(R.id.twJobItemDescription)
            twJobItemCompany = itemView.findViewById(R.id.twJobItemCompany)
            twJobDate = itemView.findViewById(R.id.twJobDate)
            twJobItemCategory = itemView.findViewById(R.id.twJobItemCategory)

            /*removeButton.setOnClickListener{
                @Suppress("DEPRECATION")
                listener.onItemDeleted(items[position])
            }*/

        }
    }
}