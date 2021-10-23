package com.example.epamapp.fragment

import com.example.epamapp.R
import com.example.epamapp.data.JobItem
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class NewJobItemDialogFragment : DialogFragment() {

    private lateinit var etJobName: EditText
    private lateinit var etDescription: EditText
    private lateinit var dpDate: DatePicker
    private lateinit var spinnerJobItemCategory: Spinner
    private lateinit var etLevel: EditText

    interface NewJobItemDialogListener {
        fun onJobItemCreated(newItem: JobItem)
    }

    private lateinit var listener: NewJobItemDialogListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? NewJobItemDialogListener
            ?: throw RuntimeException("Activity must implement the NewJobItemDialogListener interface!")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setView(getContentView())
            .setPositiveButton(R.string.save) { _, _ ->
                if (isValid()) {
                    listener.onJobItemCreated(getJobItem())
                }
            }
            .setNegativeButton(R.string.cancel, null)
            .create()
    }

    companion object {
        const val TAG = "NewJobItemDialogFragment"
    }

    @SuppressLint("InflateParams")
    private fun getContentView(): View {
        val contentView =
            LayoutInflater.from(context).inflate(R.layout.dialog_new_joboffer, null)
        etJobName = contentView.findViewById(R.id.etJobName)
        etDescription = contentView.findViewById(R.id.etDescription)
        dpDate = contentView.findViewById(R.id.dpDate)
        etLevel = contentView.findViewById(R.id.etLevel)
        spinnerJobItemCategory = contentView.findViewById(R.id.spinnerJobItemCategory)
        spinnerJobItemCategory.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.category_items)
        )
        return contentView
    }

    private fun isValid() = etJobName.text.isNotEmpty()

    private fun dateToString(datePicker: DatePicker):String{
        val year = datePicker.year.toString()
        val month = datePicker.month+1
        val day = datePicker.dayOfMonth.toString()
        return ("$year.$month.$day")
    }

    private fun getJobItem() = JobItem(
        id = null,
        name = etJobName.text.toString(),
        category = JobItem.Category.getByOrdinal(
            spinnerJobItemCategory.selectedItemPosition
        )
            ?: JobItem.Category.PHYSICAL,
        date = dateToString(dpDate),
        level = etLevel.text.toString()
    )
}