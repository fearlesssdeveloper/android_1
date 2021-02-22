package br.com.alura.agenda.dao

import br.com.alura.agenda.model.Aluno

class AlunoDAO {

    companion object {
        private val alunos = ArrayList<Aluno>()
        private var contadorDeIds = 1
    }

    fun salva(aluno: Aluno) {
        aluno.id = contadorDeIds
        alunos.add(aluno)
        contadorDeIds++
    }

    fun edita(aluno: Aluno) {
        var alunoEncontrado: Aluno? = null
        alunos.forEach {
            if (it.id == aluno.id) {
                alunoEncontrado = aluno
            }
        }

        if (alunoEncontrado != null) {
            val posicaoDoAluno = alunos.indexOf(alunoEncontrado!!)
            alunos[posicaoDoAluno] = aluno
        }
    }

    fun todos(): ArrayList<Aluno> {
        val copia = ArrayList(alunos)
        return copia
    }

}
