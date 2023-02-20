import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.example.listapersoneactivity.R

class MainActivity : AppCompatActivity() {

    // Crea un array di persone
    private var persone = arrayOf(
        Persona("Mario", "Rossi", "01/01/1990", "Roma", "RM", "M"),
        Persona("Maria", "Verdi", "02/02/1991", "Milano", "MI", "F"),
        Persona("Luigi", "Bianchi", "03/03/1992", "Napoli", "NA", "M")
    )

    // Crea un adapter per la ListView
    private lateinit var adapter: ArrayAdapter<Persona>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inizializza l'adapter e la ListView
        adapter = ArrayAdapter(this, R.layout.persona_item_layout, persone)
        val listView = findViewById<ListView>(R.id.ListaPersone)
        listView.adapter = adapter

        // Aggiungi un bottone per aggiungere persone
        val buttonAggiungiPersona = findViewById<Button>(R.id.buttonAggiungiPersona)
        buttonAggiungiPersona.setOnClickListener {
            // Crea una nuova istanza di Persona
            val nuovaPersona = Persona("Nuovo", "Persona", "01/01/2000", "Città", "Provincia", "M")

            // Aggiungi la nuova persona all'array di persone
            persone += nuovaPersona

            // Aggiorna la ListView con la nuova lista di persone
            adapter.notifyDataSetChanged()
        }
    }
}

data class Persona(
    val nome: String,
    val cognome: String,
    val dataDiNascita: String,
    val cittaDiNascita: String,
    val provinciaDiNascita: String,
    val sesso: String
) {
    override fun toString(): String {
        return "$nome $cognome - $sesso - $dataDiNascita - $cittaDiNascita ($provinciaDiNascita)"
    }
}
