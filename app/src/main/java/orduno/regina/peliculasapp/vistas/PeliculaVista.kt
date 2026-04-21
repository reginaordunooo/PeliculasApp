package orduno.regina.peliculasapp.vistas

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import orduno.regina.peliculasapp.modelos.Pelicula
import orduno.regina.peliculasapp.viewmodels.PeliculaViewModel

@Composable
fun PeliculaScreen(viewModel: PeliculaViewModel){
    val peliculas = viewModel.peliculas.value
    val context = LocalContext.current

    var mostrarDialogo by remember {mutableStateOf(false)  }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    //Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
                    mostrarDialogo = true
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar"
                )
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ){
            items(peliculas){ pelicula ->
                PeliculaCard(pelicula = pelicula, onDelete = { id ->
                    viewModel.eliminarPelicula(id)
                })
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
    if(mostrarDialogo){
        AgregarPeliculaDialog(
            onDismiss = { mostrarDialogo = false },
            onConfirm = { nombre, director, año, genero, fotoUri ->
                viewModel.agregarPelicula(nombre, director, año, genero, fotoUri)
                mostrarDialogo = false
            }
        )
    }
}

@Composable
fun PeliculaCard(pelicula: Pelicula, onDelete: (Int) -> Unit){

    Card(
        modifier = Modifier.fillMaxSize()

    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically // 🔥 CLAVE
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
            ) {
                if(pelicula.fotoUri != null){
                    AsyncImage(
                        model = pelicula.fotoUri,
                        contentDescription = "Avatar",
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = pelicula.nombre)
                    Text(text = pelicula.director)
                    Text(text = pelicula.año.toString())
                    Text(text = pelicula.genero)
                } else{
                    Image(
                        painter = painterResource(pelicula.foto),
                        contentDescription = "Avatar",
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = pelicula.nombre)
                    Text(text = pelicula.director)
                    Text(text = pelicula.año.toString())
                    Text(text = pelicula.genero)
                }
            }
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Eliminar",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onDelete(pelicula.id) }
            )
        }

    }
}

@Composable
fun AgregarPeliculaDialog(
    onDismiss: () -> Unit,
    onConfirm: (String, String, Int, String, String?) -> Unit
){
    var nombre by remember { mutableStateOf("") }
    var director by remember { mutableStateOf("") }
    var año by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var foto by remember { mutableStateOf<Uri?>(null) }

    var launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        foto = uri
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {Text("Nueva pelicula")},
        text = {
            Column {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                        .clickable {
                            launcher.launch("image/*")
                        }
                ){
                    if (foto != null){
                        AsyncImage(
                            model = foto,
                            contentDescription = "Avatar",
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    } else{
                        Icon(
                            imageVector = Icons.Default.AccountBox,
                            contentDescription = "Avatar",
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it},
                    label = { Text("Nombre") },
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = director,
                    onValueChange = { director = it },
                    label = { Text("Director") },
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = año,
                    onValueChange = { año = it },
                    label = { Text("Año de lanzamiento") },
                    singleLine = true,
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = genero,
                    onValueChange = { genero = it },
                    label = { Text("Genero") },
                    singleLine = true,
                )

            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    val añoInt = año.toIntOrNull() ?: 0
                    if (nombre.isNotBlank() && director.isNotBlank() && genero.isNotBlank() && añoInt > 0) {
                        onConfirm(nombre, director, añoInt, genero, foto?.toString())
                    }
                }
            ) {
                Text("Agregar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}