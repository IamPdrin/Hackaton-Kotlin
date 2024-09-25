package br.edu.fatecpg.hacktonkotlin.dao

import br.edu.fatecpg.hacktonkotlin.model.Contato

interface ContatoDao {
    fun cadastrarContato(contato: Contato)
    fun obterContato(): List<Contato>
}