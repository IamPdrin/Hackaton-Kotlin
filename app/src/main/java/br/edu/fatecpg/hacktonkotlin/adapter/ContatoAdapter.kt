package br.edu.fatecpg.hacktonkotlin.adapter

import android.icu.util.UniversalTimeScale.toLong
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.hacktonkotlin.R
import br.edu.fatecpg.hacktonkotlin.model.Contato
import com.bumptech.glide.Glide

class ContatoAdapter (private val contatos:List<Contato>):RecyclerView.Adapter<ContatoAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val txvNome: TextView = itemView.findViewById(R.id.txv_nome)
        val txvWhats: TextView = itemView.findViewById(R.id.txv_whats)
        val imgContato: ImageView = itemView.findViewById(R.id.img_contato)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_lista, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contato = contatos[position]
        holder.txvNome.text = contato.nome
        holder.txvWhats.text = contato.whats

        Glide.with(holder.itemView.context)
            .load(contato.link)
            .into(holder.imgContato)
    }

    override fun getItemCount(): Int {
        return contatos.size
    }

}