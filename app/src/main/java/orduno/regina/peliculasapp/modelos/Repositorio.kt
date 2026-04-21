package orduno.regina.peliculasapp.modelos

class Repositorio {

    private val usuarios = mutableListOf(
        Usuario(1, "Seokjin", "jin@gmail.com", 33, ),
        Usuario(2, "Dongmin", "min@gmail.com", 28),
        Usuario(3, "Mariana", "olwin@gmail.com", 21),
        Usuario(4, "Zule", "zu@gmail.com", 20),
        Usuario(5, "Mariana", "island@gmail.com", 21)
    )
    fun getUsuarios(): List<Usuario>{
        return usuarios.toList()
    }

    fun agregarUsuario(usuario: Usuario){
        usuarios.add(usuario)
    }

    fun eliminarUsuario(usuario: Usuario){
        usuarios.remove(usuario)
    }
}