package br.com.alura.agenda.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Aluno(val nome: String, val telefone: String, val email: String) : Parcelable{
    override fun toString(): String {
        return nome
    }
}
