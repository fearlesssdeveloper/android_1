package br.com.alura.agenda

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val alunos = mutableListOf("Alex", "Fran", "José")
        val primeiroAluno = findViewById<TextView>(R.id.textView1)
        val segundoAluno = findViewById<TextView>(R.id.textView2)
        val terceiroAluno = findViewById<TextView>(R.id.textView3)
        primeiroAluno.text = alunos[0]
        segundoAluno.text = alunos[1]
        terceiroAluno.text = alunos[2]
    }
}