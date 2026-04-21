package orduno.regina.peliculasapp.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import orduno.regina.peliculasapp.R
import orduno.regina.peliculasapp.modelos.PeliculaRepositorio
import orduno.regina.peliculasapp.modelos.Pelicula
import orduno.regina.peliculasapp.modelos.Usuario

class PeliculaViewModel (val repo: PeliculaRepositorio): ViewModel(){

    private val _peliculas = mutableStateOf<List<Pelicula>>(emptyList())
    val peliculas: State<List<Pelicula>> = _peliculas

    init {
        getPeliculas()
    }

    private fun getPeliculas(){
        _peliculas.value = repo.getPeliculas()
    }

    fun agregarPelicula(nombre: String, director: String, edad: Int, genero: String, fotoUri: String?){
        val nuevoID = peliculas.value.size + 1
        val peli = Pelicula(nuevoID, nombre, director, edad, genero, R.drawable.bootstrap_person_circle, fotoUri)
        repo.agregarPelicula(peli)

        _peliculas.value = repo.getPeliculas()
    }

    fun eliminarPelicula(id: Int){
        repo.eliminarPelicula(id)
        _peliculas.value = repo.getPeliculas()
    }

}
