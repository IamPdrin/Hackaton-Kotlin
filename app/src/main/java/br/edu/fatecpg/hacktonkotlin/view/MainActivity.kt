package br.edu.fatecpg.hacktonkotlin.view

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.hacktonkotlin.R
import br.edu.fatecpg.hacktonkotlin.dao.ContatoDaoImpl
import br.edu.fatecpg.hacktonkotlin.model.Contato
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    val dao = ContatoDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNome = findViewById<TextInputEditText>(R.id.edt_nome)
        val edtWhats = findViewById<TextInputEditText>(R.id.edt_whats)
        val edtLink = findViewById<TextInputEditText>(R.id.edt_link)
        val txvLista = findViewById<TextView>(R.id.txv_lista)

        val btnCadastrar = findViewById<AppCompatButton>(R.id.btn_cadastrar)

        btnCadastrar.setOnClickListener {
            val nome = edtNome.text.toString()
            val whats = edtWhats.text.toString()
            val link = edtLink.text.toString()

            val contato = Contato(nome, whats, link)

            dao.cadastrarContato(contato)

            Toast.makeText(this, "Contato Cadastrado com Sucesso!", Toast.LENGTH_SHORT).show()

            edtNome.text?.clear()
            edtWhats.text?.clear()
            edtLink.text?.clear()
        }

        txvLista.setOnClickListener{
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }

    }
}