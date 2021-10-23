package com.example.epamapp.adapter

class OfferedJobAdapter {
}


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class ToDoAdapter(private val listener: ToDoItemClickListener) :
    RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    private val items = mutableListOf<ToDoItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val itemView: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_todo_list, parent, false)
        return ToDoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.dateTextView.text=item.date
        holder.categoryTextView.text = item.category.name
        holder.isDoneCheckBox.isChecked = item.isDone

        holder.item = item
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItem(item: ToDoItem) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun deleteItem(item: ToDoItem){
        val position=items.indexOf(item)
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun update(todoItems: List<ToDoItem>) {
        items.clear()
        items.addAll(todoItems)
        notifyDataSetChanged()
    }

    interface ToDoItemClickListener {
        fun onItemChanged(item: ToDoItem)
        fun onItemDeleted(item: ToDoItem)
    }

    inner class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val nameTextView: TextView
        val dateTextView: TextView
        val categoryTextView: TextView
        val isDoneCheckBox: CheckBox
        private val removeButton: ImageButton

        var item: ToDoItem? = null

        init {
            nameTextView = itemView.findViewById(R.id.ToDoItemNameTextView)
            dateTextView = itemView.findViewById(R.id.ToDoItemDateTextView)
            categoryTextView = itemView.findViewById(R.id.ToDoItemCategoryTextView)
            isDoneCheckBox = itemView.findViewById(R.id.ToDoItemIsDoneCheckBox)
            removeButton = itemView.findViewById(R.id.ToDoItemRemoveButton)
            removeButton.setOnClickListener{
                @Suppress("DEPRECATION")
                listener.onItemDeleted(items[position])
            }
            isDoneCheckBox.setOnCheckedChangeListener { _, isDone ->
                item?.let {
                    val newItem = it.copy(
                        isDone = isDone
                    )
                    item = newItem
                    listener.onItemChanged(newItem)
                }
            }
        }
    }
}