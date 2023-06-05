package com.example.mvvmpattern.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmpattern.repository.UserRepository
import com.example.mvvmpattern.view.IView

class ViewModelFactory(
    private val loginView: IView,
    private val userRepository: UserRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java))
            return LoginViewModel(loginView, userRepository) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
