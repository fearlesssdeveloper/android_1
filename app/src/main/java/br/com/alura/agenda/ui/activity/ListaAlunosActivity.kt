package br.com.alura.agenda.ui.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.agenda.R
import br.com.alura.agenda.dao.AlunoDAO
import br.com.alura.agenda.model.Aluno

class ListaAlunosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_alunos)

        val dao = AlunoDAO()

        title = "Lista de Alunos"
        val alunos = mutableListOf("Alex", "Fran", "José", "Maria", "Anna")
        val listaDeAlunos = findViewById<ListView>(R.id.activity_lista_alunos_listview)
        listaDeAlunos.adapter = ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, dao.alunos)

    }
}