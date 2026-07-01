package com.example.mvvc.repository

import com.example.mvvc.model.User
import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUsers(): List<User> {
        delay(2000)
        return listOf(
            User(1, "Ana García", "ana@email.com"),
            User(2, "Luis Pérez", "luis@email.com"),
            User(3, "Marta Díaz", "marta@email.com")
        )
    }
}
