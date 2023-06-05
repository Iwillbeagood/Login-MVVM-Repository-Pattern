package com.example.mvvmpattern.repository

import com.example.mvvmpattern.model.User
import retrofit2.Callback

interface UserRepository {
    fun sendUserData(user: User, callback: Callback<Boolean>)
}