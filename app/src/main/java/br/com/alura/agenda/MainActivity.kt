package br.com.alura.agenda

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Lista de Alunos"
        val alunos = mutableListOf("Alex", "Fran", "José", "Maria", "Anna")
        val listaDeAlunos = findViewById<ListView>(R.id.activity_main_lista_de_alunos)
        listaDeAlunos.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos)

    }
}