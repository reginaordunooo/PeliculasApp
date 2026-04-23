package orduno.regina.peliculasapp.modelos

import orduno.regina.peliculasapp.R

class PeliculaRepositorio {

    private val peliculas = mutableListOf(
        Pelicula(1, "Harry Potter and the Goblet of Fire", "Mike Newell", 2005, "Fantasy", R.drawable.bootstrap_person_circle),
        Pelicula(2, "Barbie in the 12 Dancing Princesses", "Terry Klassen", 2006, "Animation", R.drawable.bootstrap_person_circle),
        Pelicula(3, "Batman: The Dark Knight", "Christopher Nolan", 2009, "Fantasy", R.drawable.bootstrap_person_circle),
        Pelicula(4, "The Amazing Spider-Man", "Marc Webb", 2012, "Fantasy", R.drawable.bootstrap_person_circle),
        Pelicula(5, "Ratatouille", "Brad Bird", 2007, "Animation", R.drawable.bootstrap_person_circle)
    )
    fun getPeliculas(): List<Pelicula>{
        return peliculas.toList()
    }

    fun agregarPelicula(pelicula: Pelicula){
        peliculas.add(pelicula)
    }

    fun eliminarPelicula(id: Int){
        peliculas.removeIf { it.id == id }
    }

    fun  editarPelicula(pelicula: Pelicula){
        val indice = peliculas.indexOfFirst { it.id == pelicula.id}

        if (indice != -1){
            peliculas[indice] = pelicula
        }
    }

}