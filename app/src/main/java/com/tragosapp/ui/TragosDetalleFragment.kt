package com.tragosapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tragosapp.R
import com.tragosapp.data.model.Drink

class TragosDetalleFragment : Fragment() {

    private lateinit var drink: Drink

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let{
            drink = it.getParcelable<Drink>("drink")!!
            Log.d("DETALLES_FRAG","${drink.toString()}")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tragos_detalle, container, false)
    }
}