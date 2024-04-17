package com.example.app30das

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app30das.ui.theme.App30DíasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App30DíasTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MainContent()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent() {
    Column {
        TopAppBar(
            title = { Text(text = "30 días de buen hábito saludable") }
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            CardList()
        }
    }
}

@Composable
fun CardList() {
    // Arreglo de títulos personalizados para cada carta
    val titles = listOf(
        "Día 1 -> Trota",
        "Día 2 -> Flexiones",
        "Día 3 -> Sentadillas",
        "Día 4 -> Salta la cuerda",
        "Día 5 -> Mancuernas",
        "Día 6 -> Zumba",
        "Día 7 -> Abdominales",
        "Día 8 -> Relajación",
        "Día 9 -> Bicicleta",
        "Día 10 -> Caminata",
        "Día 11 -> Trota Pt. 2",
        "Día 12 -> Flexiones Pt.2",
        "Día 13 -> Sentadillas Pt.2",
        "Día 14 -> Salta la cuerda Pt.2",
        "Día 15 -> Mancuernas Pt.2",
        "Día 16 -> Zumba Pt.2",
        "Día 17 -> Abdominales Pt.2",
        "Día 18 -> Relajación Pt.2",
        "Día 19 -> Bicicleta Pt.2",
        "Día 20 -> Caminata Pt.2",
        "Día 21 -> Trota Pt.3",
        "Día 22 -> Flexiones Pt.3",
        "Día 23 -> Sentadillas Pt.3",
        "Día 24 -> Salta la cuerda Pt.3",
        "Día 25 -> Mancuernas Pt.3",
        "Día 26 -> Zumba Pt.3",
        "Día 27 -> Abdominales Pt.3",
        "Día 28 -> Relajación Pt.3",
        "Día 29 -> Bicicleta Pt.3",
        "Día 30 -> Caminata Pt.3",
    )

    // Arreglo de descripciones personalizadas para cada carta
    val descriptions = listOf(
        "Realiza un recorrido en trote durante 25 minutos.",
        "Realiza 10 Flexiones(Lagartijas) para fortalecer los brazos(2 repeticiones).",
        "Realiza 15 Sentadillas para trabajar los glúteos.",
        "Salta la cuerda durante 2 minutos.",
        "Levanta peso con mancuernas de 8 o 10 kg(según sea tu necesidad).",
        "Práctica ejercicio con todo tu cuerpo realizando 30 minutos de Zumba.",
        "Fortalece tu abdomen realizando 10 abdominales(3 repeticiones).",
        "Relaja tu cuerpo haciendo 20 minutos de meditación y 20 minutos de lectura(mente y cerebro descansado).",
        "Da un paseo en bicicleta por tu barrio o una zona que te guste donde vivas(40 minutos)",
        "Descansa la piernas caminando 30 minutos en un ambiente cálido y agradable."
    )

    // Arreglo de imágenes personalizadas para cada carta
    val images = listOf(
        R.drawable.imagen2,
        R.drawable.flexiones,
        R.drawable.sentadillas,
        R.drawable.cuerda,
        R.drawable.mancuernas,
        R.drawable.zumba,
        R.drawable.abdominal,
        R.drawable.relajacion,
        R.drawable.bicicleta,
        R.drawable.caminata,
        R.drawable.imagen2,
        R.drawable.flexiones,
        R.drawable.sentadillas,
        R.drawable.cuerda,
        R.drawable.mancuernas,
        R.drawable.zumba,
        R.drawable.abdominal,
        R.drawable.relajacion,
        R.drawable.bicicleta,
        R.drawable.caminata,
        R.drawable.imagen2,
        R.drawable.flexiones,
        R.drawable.sentadillas,
        R.drawable.cuerda,
        R.drawable.mancuernas,
        R.drawable.zumba,
        R.drawable.abdominal,
        R.drawable.relajacion,
        R.drawable.bicicleta,
        R.drawable.caminata,
    )

    LazyColumn {
        items(titles.size) { index ->
            val title = titles.getOrNull(index) ?: "Día ${index + 1} - Título"
            val description = descriptions.getOrNull(index) ?: "Descripción del día ${index + 1}"
            val image = images.getOrNull(index) ?: R.drawable.imagen1
            val context = LocalContext.current
            CardItem(
                title = title,
                description = description,
                image = image,
                context = context
            )
        }
    }
}

fun showCompletionAlert(context: Context) {
    val builder = AlertDialog.Builder(context)
    builder.setTitle("¡Felicidades!")
    builder.setMessage("¡Has completado esta actividad!")
    builder.setPositiveButton("Aceptar", null)
    builder.show()
}

@Composable
fun CardItem(title: String, description: String, image: Int, context: Context) {
    var showRecomendationDialog by remember { mutableStateOf(false) }
    var recommendationText by remember { mutableStateOf("") }
    var completedActivityDialogShown by remember { mutableStateOf(false) }
    var noteText by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        color = Color.LightGray
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth() // Ocupa todo el ancho disponible
                .fillMaxHeight() // Ajusta la altura según el contenido
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp), // Ajusta la altura de la imagen
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                modifier = Modifier.padding(horizontal = 8.dp),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                modifier = Modifier.padding(horizontal = 8.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            Button(
                onClick = {
                    // Mostrar la ventana modal de recomendaciones
                    showRecomendationsDialog(context)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(text = "Recomendaciones")
            }
            Button(
                onClick = {
                    if (!completedActivityDialogShown) {
                        // Mostrar la alerta al completar solo si no se ha mostrado antes
                        showCompletionAlert(context)
                        completedActivityDialogShown = true
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(text = "Completar")
            }
            Button(
                onClick = {
                    showNotesDialog(context) { note ->
                        noteText = note
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(text = "Guardar Nota")
            }
        }
    }
}

fun showNotesDialog(context: Context, onNoteSaved: (String) -> Unit) {
    val input = EditText(context)
    AlertDialog.Builder(context)
        .setTitle("Guardar Nota")
        .setView(input)
        .setPositiveButton("Guardar") { _, _ ->
            val note = input.text.toString()
            onNoteSaved(note)
        }
        .setNegativeButton("Cancelar", null)
        .show()
}

fun showRecomendationsDialog(context: Context) {
    AlertDialog.Builder(context).apply {
        setTitle("Recomendaciones de Ejercicio")
        val recommendations = """
            |1. Mantén una hidratación adecuada antes, durante y después del ejercicio.
            |2. Realiza un calentamiento adecuado antes de comenzar tu rutina de ejercicios para evitar lesiones.
            |3. Escucha a tu cuerpo y no fuerces los límites si sientes dolor o fatiga excesiva.
            |4. Incorpora ejercicios de estiramiento al final de tu rutina para mejorar la flexibilidad y reducir el riesgo de lesiones.
            |5. Asegúrate de utilizar el equipo de protección adecuado, como casco, rodilleras y coderas, si practicas deportes de riesgo.
            |6. Varía tu rutina de ejercicios para trabajar diferentes grupos musculares y evitar el aburrimiento.
            |7. Descansa lo suficiente entre sesiones de entrenamiento para permitir que tus músculos se recuperen y crezcan.
            |8. Mantén una dieta equilibrada y rica en nutrientes para respaldar tus esfuerzos de entrenamiento.
            |9. Consulta a un médico o entrenador personal si tienes alguna preocupación sobre tu salud o tus objetivos de fitness.
            |10. Disfruta del proceso y celebra tus logros, incluso si son pequeños. ¡Cada paso cuenta!
        """.trimMargin()
        setMessage(recommendations)
        setPositiveButton("Aceptar", null)
    }.show()
  }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    App30DíasTheme {
        MainContent()
    }
}
