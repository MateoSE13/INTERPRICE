package com.example.Interprice.service

import com.example.Interprice.entity.OrderItem
import com.example.Interprice.repository.OrderItemRepository
import org.springframework.stereotype.Service

@Service
class OrderItemService(private val orderItemRepository:  OrderItemRepository) {

    fun findAll(): List<OrderItem> = orderItemRepository.findAll()

    fun findById(id: Int): OrderItem? = orderItemRepository.findById(id).orElse(null)

    fun save(orderItem: OrderItem): OrderItem = orderItemRepository.save(orderItem)

    fun update(id: Int, updatedOrderItem: OrderItem): OrderItem? {
        return if (orderItemRepository.existsById(id)) {
            orderItemRepository.save(updatedOrderItem.copy(id = id))
        } else {
            null
        }
    }

    fun deleteById(id: Int) {
        if (orderItemRepository.existsById(id)) {
            orderItemRepository.deleteById(id)
        }
    }
}
