package br.edu.fatecpg.hacktonkotlin.dao

import br.edu.fatecpg.hacktonkotlin.model.Contato

class ContatoDaoImpl:ContatoDao {
    companion object {
        private val contatos = mutableListOf<Contato>()
    }

    override fun cadastrarContato(contato: Contato) {
        contatos.add(contato)
    }

    override fun obterContato(): List<Contato> {
        return contatos
    }
}