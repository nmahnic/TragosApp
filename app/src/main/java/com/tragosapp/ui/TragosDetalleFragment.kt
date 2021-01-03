package com.tragosapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.tragosapp.R
import com.tragosapp.data.model.Drink
import kotlinx.android.synthetic.main.fragment_tragos_detalle.*

class TragosDetalleFragment : Fragment() {

    private lateinit var drink: Drink

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let{
            drink = it.getParcelable<Drink>("drink")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tragos_detalle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(drink.image).centerCrop().into(img_trago)
        trago_title.text = drink.nombre
        trago_desc.text = drink.descripcion
        if(drink.hasAlcohol.equals("Non_Alcoholic")) {
            txt_has_alcohol.text = "Bebida sin alcohol"
        }else{
            txt_has_alcohol.text = "Bebida con alcohol"
        }
    }
}