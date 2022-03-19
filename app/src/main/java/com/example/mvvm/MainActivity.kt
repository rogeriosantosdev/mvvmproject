package com.example.mvvm

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ViewBinding {
    private lateinit var viewModel : MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.textWelcome.observe(this, Observer {
            binding.textWelcome.text = it
        })

        viewModel.login.observe(this, Observer {
            if(it){
                Toast.makeText(applicationContext, "Sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Falha!", Toast.LENGTH_SHORT).show()

            }
        })

        binding.buttonLogin.setOnClickListener{
            val name = binding.editName.text.toString()
            viewModel.login(name)
        }
    }

    override fun getRoot(): View {
        TODO("Not yet implemented")
    }
}