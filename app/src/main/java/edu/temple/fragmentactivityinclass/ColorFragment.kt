package edu.temple.fragmentactivityinclass

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner

class ColorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false)
    }

    // The view passed in here is the layout created in onCreateView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // This is also the inflated layout.
        //this.view

        view.apply {
            findViewById<Spinner>(R.id.spinner).apply {
                adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item,
                    arrayOf("Blue", "Cyan", "Magenta", "Red", "Yellow"))

                onItemSelectedListener = object: OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        parent?.run {
                            this@ColorFragment.view?.setBackgroundColor(Color.parseColor(getItemAtPosition(position).toString()))
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }
                }
            }
        }
    }
}