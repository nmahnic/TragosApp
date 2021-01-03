package com.tragosapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.tragosapp.AppDatabase
import com.tragosapp.R
import com.tragosapp.data.DataSource
import com.tragosapp.data.model.Drink
import com.tragosapp.data.model.DrinkEntity
import com.tragosapp.domain.RepoImpl
import com.tragosapp.ui.viewmodel.MainViewModel
import com.tragosapp.ui.viewmodel.VMFactory
import kotlinx.android.synthetic.main.fragment_tragos_detalle.*

class TragosDetalleFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel> {
        VMFactory(
            RepoImpl(
                DataSource(
                    AppDatabase.getDatabase(requireActivity().applicationContext)
                )
            )
        )
    }

    private lateinit var drink: Drink

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
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
        if (drink.hasAlcohol.equals("Non_Alcoholic")) {
            txt_has_alcohol.text = "Bebida sin alcohol"
        } else {
            txt_has_alcohol.text = "Bebida con alcohol"
        }

        btn_guardar_trago.setOnClickListener {
            viewModel.guardarTrago(
                DrinkEntity(
                    drink.tragoId,
                    drink.image,
                    drink.nombre,
                    drink.descripcion,
                    drink.hasAlcohol
                )
            )
            Toast.makeText(requireContext(), "Se guardo el trago en favoritos", Toast.LENGTH_SHORT)
                .show()
        }
    }
}