package orduno.regina.peliculasapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import orduno.regina.peliculasapp.modelos.Repositorio

class UsuarioViewModelFactory(private val repo: Repositorio): ViewModelProvider.Factory {

    override fun <T: ViewModel> create(modelClass: Class<T>): T{
        //return super.create(ModelClass)
        if (modelClass.isAssignableFrom(UsuarioViewModel::class.java)){
            return UsuarioViewModel(repo) as T
        }
        throw IllegalArgumentException("Desconocido")
    }

}