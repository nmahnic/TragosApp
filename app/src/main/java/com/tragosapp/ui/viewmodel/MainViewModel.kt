package com.tragosapp.ui.viewmodel

import androidx.lifecycle.*
import com.tragosapp.domain.Repo
import com.tragosapp.vo.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repo: Repo): ViewModel() {

    private val tragosData = MutableLiveData<String>()

    init {
        setTrago("margarita")
    }

    fun setTrago(tragoName: String){
        tragosData.value = tragoName
    }

    val fetchTragosList = tragosData.distinctUntilChanged().switchMap {nombreTrago ->
        liveData(Dispatchers.IO){
            emit(Resource.Loading())
            try{
                emit(repo.getTragosList(nombreTrago))
            }catch (e: Exception){
                emit(Resource.Failure(e))
            }
        }
    }
}