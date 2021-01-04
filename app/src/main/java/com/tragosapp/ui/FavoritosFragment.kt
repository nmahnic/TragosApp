package com.tragosapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tragosapp.AppDatabase
import com.tragosapp.R
import com.tragosapp.data.DataSource
import com.tragosapp.data.model.Drink
import com.tragosapp.data.model.DrinkEntity
import com.tragosapp.domain.RepoImpl
import com.tragosapp.ui.viewmodel.MainViewModel
import com.tragosapp.ui.viewmodel.VMFactory
import com.tragosapp.vo.Resource
import kotlinx.android.synthetic.main.fragment_favoritos.*
import kotlinx.android.synthetic.main.fragment_main.*
import java.text.FieldPosition


class FavoritosFragment : Fragment(), MainAdapter.OnTragoClickListener {

    private val viewModel by viewModels<MainViewModel> {
        VMFactory(
            RepoImpl(
                DataSource(
                    AppDatabase.getDatabase(
                        requireActivity().applicationContext
                    )
                )
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favoritos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleView()
        setupObservers()
    }

    private fun setupObservers(){
        viewModel.getTragosFavoritos().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Loading -> {}
                is Resource.Success -> {
                    val lista = result.data.map{
                        Drink(it.tragoId,it.image,it.nombre,it.descripcion,it.hasAlcohol)
                    }
                    rv_tragos_favoritos.adapter = MainAdapter(requireContext(),lista,this)
                }
                is Resource.Failure -> {}
            }
        })
    }

    private fun setupRecycleView(){
        rv_tragos_favoritos.layoutManager = LinearLayoutManager(requireContext())
        rv_tragos_favoritos.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
    }

    override fun onTragoClick(drink: Drink, position: Int) {
        viewModel.deleteTrago(
            DrinkEntity(
                drink.tragoId,
                drink.image,
                drink.nombre,
                drink.descripcion,
                drink.hasAlcohol
            )
        )
        rv_tragos_favoritos.adapter?.notifyItemRemoved(position)
//        rv_tragos_favoritos.adapter?.notifyItemRangeRemoved(position,rv_tragos_favoritos.adapter?.itemCount!!)
        Toast.makeText(requireContext(), "Trago Eliminado", Toast.LENGTH_SHORT).show()
    }
}