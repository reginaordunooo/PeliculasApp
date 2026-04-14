package orduno.regina.peliculasapp.modelos

class PeliculaRepositorio {

    fun getPeliculas(): List<Pelicula>{
        return listOf(
            Pelicula(1, "Harry Potter and the Goblet of Fire", "Mike Newell", 2005, "Fantasy"),
            Pelicula(2, "Barbie in the 12 Dancing Princesses", "Terry Klassen", 2006, "Animation"),
            Pelicula(3, "Batman: The Dark Knight", "Christopher Nolan", 2009, "Fantasy"),
            Pelicula(4, "The Amazing Spider-Man", "Marc Webb", 2012, "Fantasy"),
            Pelicula(5, "Ratatouille", "Brad Bird", 2007, "Animation")
        )
    }
}