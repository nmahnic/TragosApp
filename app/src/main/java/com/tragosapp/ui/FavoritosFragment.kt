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
import com.tragosapp.AppDatabase
import com.tragosapp.R
import com.tragosapp.data.DataSource
import com.tragosapp.domain.RepoImpl
import com.tragosapp.ui.viewmodel.MainViewModel
import com.tragosapp.ui.viewmodel.VMFactory
import com.tragosapp.vo.Resource
import kotlinx.android.synthetic.main.fragment_main.*


class FavoritosFragment : Fragment() {

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
        viewModel.getTragosFavoritos().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Loading -> {}
                is Resource.Success -> {
                    Log.d("LISTA_FAVORITOS","${result.data}")
                }
                is Resource.Failure -> {}
            }
        })
    }
}