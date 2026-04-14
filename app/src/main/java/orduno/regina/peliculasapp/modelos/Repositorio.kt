package orduno.regina.peliculasapp.modelos

class Repositorio {

    fun getUsuarios(): List<Usuario>{
        return listOf(
            Usuario(1, "Seokjin", "jin@gmail.com", 33),
            Usuario(2, "Dongmin", "min@gmail.com", 28),
            Usuario(3, "Mariana", "olwin@gmail.com", 21),
            Usuario(4, "Zule", "zu@gmail.com", 20),
            Usuario(5, "Mariana", "island@gmail.com", 21)
        )
    }
}