package br.com.alura.agenda.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Aluno(var id: Int = 0, var nome: String, var telefone: String, var email: String) : Parcelable{

    override fun toString(): String {
        return nome
    }
}
