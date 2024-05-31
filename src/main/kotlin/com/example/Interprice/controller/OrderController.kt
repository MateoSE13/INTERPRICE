package com.example.Interprice.controller

import com.example.Interprice.entity.Order
import com.example.Interprice.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orders")
class OrderController(private val orderService:  OrderService) {

    @GetMapping
    fun getAllOrders(): ResponseEntity<List<Order>> = ResponseEntity.ok(orderService.findAll())

    @GetMapping("/{id}")
    fun getOrderById(@PathVariable id: Int): ResponseEntity<Order> {
        val order = orderService.findById(id)
        return if (order != null) {
            ResponseEntity.ok(order)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createOrder(@RequestBody order: Order): ResponseEntity<Order> {
        val createdOrder = orderService.save(order)
        return ResponseEntity.ok(createdOrder)
    }

    @PutMapping("/{id}")
    fun updateOrder(@PathVariable id: Int, @RequestBody order: Order): ResponseEntity<Order> {
        val updatedOrder = orderService.update(id, order)
        return if (updatedOrder != null) {
            ResponseEntity.ok(updatedOrder)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteOrder(@PathVariable id: Int): ResponseEntity<Void> {
        orderService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}
