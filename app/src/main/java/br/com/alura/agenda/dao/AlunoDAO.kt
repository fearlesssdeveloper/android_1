package br.com.alura.agenda.dao

import br.com.alura.agenda.model.Aluno

class AlunoDAO {

    var alunos = ArrayList<Aluno>()
        private set

    fun salva(aluno: Aluno) {
        alunos.add(aluno)
    }

}
