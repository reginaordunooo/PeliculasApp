package orduno.regina.peliculasapp.modelos

data class Pelicula(val id: Int, var nombre: String, var director: String, var año: Int, var genero: String, var foto: Int, var fotoUri: String? = null)
