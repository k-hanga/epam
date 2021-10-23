package com.example.epamapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.epamapp.R
import com.example.epamapp.data.AppliedJobItem

class AppliedJobAdapter(private val listener: AppliedJobItemClickListener) :
    RecyclerView.Adapter<AppliedJobAdapter.AppliedJobViewHolder>() {

    private val items = mutableListOf<AppliedJobItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppliedJobViewHolder {
        val itemView: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_job_list, parent, false)
        return AppliedJobViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AppliedJobViewHolder, position: Int) {
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

    fun addItem(item: AppliedJobItem) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun deleteItem(item: AppliedJobItem){
        val position=items.indexOf(item)
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun update(appliedJobItems: List<AppliedJobItem>) {
        items.clear()
        items.addAll(appliedJobItems)
        notifyDataSetChanged()
    }

    interface AppliedJobItemClickListener {
        fun onItemChanged(item: AppliedJobItem)
        fun onItemDeleted(item: AppliedJobItem)
    }

    inner class AppliedJobViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val twJobItemName: TextView
        val twJobItemDescription: TextView
        val twJobItemCompany: TextView
        val twJobDate: TextView
        val twJobItemCategory: TextView

        var item: AppliedJobItem? = null

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