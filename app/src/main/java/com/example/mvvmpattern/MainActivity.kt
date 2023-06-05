package com.example.mvvmpattern

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmpattern.databinding.ActivityMainBinding
import com.example.mvvmpattern.repository.UserRepository
import com.example.mvvmpattern.repository.UserRepositoryImpl
import com.example.mvvmpattern.view.IView
import com.example.mvvmpattern.viewmodel.LoginViewModel
import com.example.mvvmpattern.viewmodel.ViewModelFactory


class MainActivity : AppCompatActivity(), IView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        // UserRepository 구현체 생성
        userRepository = UserRepositoryImpl()

        // ViewModelFactory 생성 시 UserRepository 인스턴스도 주입
        val loginViewModelFactory = ViewModelFactory(this, userRepository)

        binding.viewModel = ViewModelProvider(this, loginViewModelFactory)[LoginViewModel::class.java]
    }

    override fun onLoginSuccess(message: String?) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }

    override fun onLoginError(message: String?) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }
}