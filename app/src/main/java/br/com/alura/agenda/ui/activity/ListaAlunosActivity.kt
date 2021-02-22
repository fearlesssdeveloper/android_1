package br.com.alura.agenda.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.agenda.R
import br.com.alura.agenda.dao.AlunoDAO
import br.com.alura.agenda.model.Aluno
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaAlunosActivity : AppCompatActivity() {

    private val dao = AlunoDAO()
    private lateinit var alunos: ArrayList<Aluno>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_alunos)
        title = "Lista de Alunos"
        configuraFabNovoAluno()
        dao.salva(Aluno(nome = "José", telefone = "111.111.111-11", email = "ze_harlan@me.com"))
        dao.salva(Aluno(nome = "Anna", telefone = "111.111.111-11", email = "anna@me.com"))
    }

    private fun configuraFabNovoAluno() {
        val botaoNovoAluno =
            findViewById<FloatingActionButton>(R.id.activity_lista_alunos_fab_novo_aluno)
        botaoNovoAluno.setOnClickListener {
            abreFormularioAlunoActivity()
        }
    }

    private fun abreFormularioAlunoActivity() {
        startActivity(Intent(this, FormularioAlunoActivity::class.java))
    }

    override fun onResume() {
        super.onResume()
        configuraLista()
    }

    private fun configuraLista() {
        val listaDeAlunos = findViewById<ListView>(R.id.activity_lista_alunos_listview)
        alunos = dao.todos()
        listaDeAlunos.adapter =
            ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunos)
        listaDeAlunos.setOnItemClickListener { adapterView, view, posicao, id ->
            val aluno = alunos[posicao]
            val intent = Intent(this, FormularioAlunoActivity::class.java)
            intent.putExtra("aluno", aluno)
            startActivity(intent)
            Log.i("aluno", "id: ${aluno.id}")
        }
    }
}