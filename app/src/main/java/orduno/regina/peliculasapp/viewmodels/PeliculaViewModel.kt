package orduno.regina.peliculasapp.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import orduno.regina.peliculasapp.modelos.PeliculaRepositorio
import orduno.regina.peliculasapp.modelos.Pelicula

class PeliculaViewModel (val repo: PeliculaRepositorio): ViewModel(){

    private val _peliculas = mutableStateOf<List<Pelicula>>(emptyList())
    val peliculas: State<List<Pelicula>> = _peliculas

    init {
        getPeliculas()
    }

    private fun getPeliculas(){
        _peliculas.value = repo.getPeliculas()
    }

}
