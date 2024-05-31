package com.example.Interprice.service

import com.example.Interprice.entity.User
import com.example.Interprice.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository:  UserRepository) {

    fun findAll(): List<User> = userRepository.findAll()

    fun findById(id: Int): User? = userRepository.findById(id).orElse(null)

    fun save(user: User): User = userRepository.save(user)

    fun update(id: Int, updatedUser: User): User? {
        return if (userRepository.existsById(id)) {
            userRepository.save(updatedUser.copy(id = id))
        } else {
            null
        }
    }

    fun deleteById(id: Int) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
        }
    }
}
