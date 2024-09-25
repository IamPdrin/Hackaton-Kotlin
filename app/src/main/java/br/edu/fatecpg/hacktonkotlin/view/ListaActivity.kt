package br.edu.fatecpg.hacktonkotlin.view

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.hacktonkotlin.R
import br.edu.fatecpg.hacktonkotlin.adapter.ContatoAdapter
import br.edu.fatecpg.hacktonkotlin.dao.ContatoDaoImpl
import br.edu.fatecpg.hacktonkotlin.model.Contato

class ListaActivity : AppCompatActivity() {

    val dao = ContatoDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)


        Log.i("CONTATO", dao.obterContato().toString())


        val rvContatos = findViewById<RecyclerView>(R.id.rcv_contato)
        val contatos = dao.obterContato()

        rvContatos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvContatos.adapter = ContatoAdapter(contatos)
    }
}