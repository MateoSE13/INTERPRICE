package com.example.Interprice.service

import com.example.Interprice.entity.Order
import com.example.Interprice.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(private val orderRepository:  OrderRepository) {

    fun findAll(): List<Order> = orderRepository.findAll()

    fun findById(id: Int): Order? = orderRepository.findById(id).orElse(null)

    fun save(order: Order): Order = orderRepository.save(order)

    fun update(id: Int, updatedOrder: Order): Order? {
        return if (orderRepository.existsById(id)) {
            orderRepository.save(updatedOrder.copy(id = id))
        } else {
            null
        }
    }

    fun deleteById(id: Int) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id)
        }
    }
}
