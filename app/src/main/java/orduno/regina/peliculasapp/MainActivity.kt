package orduno.regina.peliculasapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import orduno.regina.peliculasapp.modelos.PeliculaRepositorio
import orduno.regina.peliculasapp.modelos.Repositorio
import orduno.regina.peliculasapp.ui.theme.PeliculasAppTheme
import orduno.regina.peliculasapp.viewmodels.PeliculaViewModel
import orduno.regina.peliculasapp.viewmodels.PeliculaViewModelFactory
import orduno.regina.peliculasapp.viewmodels.UsuarioViewModel
import orduno.regina.peliculasapp.viewmodels.UsuarioViewModelFactory
import orduno.regina.peliculasapp.vistas.PeliculaScreen
import orduno.regina.peliculasapp.vistas.UsuarioScreen

class MainActivity : ComponentActivity() {
    private val TAG = "Peliculas"

//    private val viewModel: UsuarioViewModel by viewModels{
//        UsuarioViewModelFactory(Repositorio())
//    }

    private val viewModel: PeliculaViewModel by viewModels{
        PeliculaViewModelFactory(PeliculaRepositorio())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        Log.d(TAG, "Create")

        Toast.makeText(this, "Create", Toast.LENGTH_SHORT).show()
        setContent {
//            PeliculasAppTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
            //UsuarioScreen(viewModel = viewModel)
            PeliculaScreen(viewModel = viewModel)
        }
    }

//    override fun onStart() {
//        super.onStart()
//
//        Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show()
//        Log.d(TAG, "Start")
//    }
//
//    override fun onResume() {
//        super.onResume()
//
//        Toast.makeText(this, "Resume", Toast.LENGTH_SHORT).show()
//        Log.d(TAG, "Resume")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//
//        Toast.makeText(this, "Destroy", Toast.LENGTH_SHORT).show()
//        Log.d(TAG, "Destroy")
//    }
//
//    override fun onStop() {
//        super.onStop()
//
//        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show()
//        Log.d(TAG, "Stop")
//    }
//
//    override fun onPause() {
//        super.onPause()
//
//        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show()
//        Log.d(TAG, "Pause")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//
//        Toast.makeText(this, "Restart", Toast.LENGTH_SHORT).show()
//        Log.d(TAG, "Restart")
//    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PeliculasAppTheme {
        Greeting("Android")
    }
}