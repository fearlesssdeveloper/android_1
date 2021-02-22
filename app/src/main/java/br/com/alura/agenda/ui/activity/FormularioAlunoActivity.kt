package br.com.alura.agenda.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.agenda.R
import br.com.alura.agenda.dao.AlunoDAO
import br.com.alura.agenda.model.Aluno


class FormularioAlunoActivity : AppCompatActivity() {

    private lateinit var aluno: Aluno
    private val dao = AlunoDAO()
    private lateinit var campoNome: EditText
    private lateinit var campoTelefone: EditText
    private lateinit var campoEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_aluno)

        title = "Novo aluno"
        inicializacaoDosCampos()
        configuraBotaoSalvar()

        val dados = intent
        aluno = dados.getParcelableExtra("aluno") as Aluno
        campoNome.setText(aluno.nome)
        campoTelefone.setText(aluno.telefone)
        campoEmail.setText(aluno.email)
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_aluno_botao_salvar)
        botaoSalvar.setOnClickListener {
//            val aluno = preencheAluno()
//            salva(aluno)
            preencheAluno()
            dao.edita(aluno)
            finish()
        }
    }

    private fun inicializacaoDosCampos() {
        campoNome = findViewById<EditText>(R.id.activity_formulario_aluno_nome)
        campoTelefone = findViewById<EditText>(R.id.activity_formulario_aluno_telefone)
        campoEmail = findViewById<EditText>(R.id.activity_formulario_aluno_email)
    }

    private fun salva(aluno: Aluno) {
        dao.salva(aluno)
        finish()
    }

    private fun preencheAluno() {
        val nome = campoNome.text.toString()
        val telefone = campoTelefone.text.toString()
        val email = campoEmail.text.toString()
        aluno.nome = nome
        aluno.telefone = telefone
        aluno.email = email

//        return Aluno(nome = nome, telefone = telefone, email = email)
    }
}