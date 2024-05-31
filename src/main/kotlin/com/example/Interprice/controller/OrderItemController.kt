package com.example.Interprice.controller

import com.example.Interprice.entity.OrderItem
import com.example.Interprice.service.OrderItemService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/order-items")
class OrderItemController(private val orderItemService: OrderItemService) {

    @GetMapping
    fun getAllOrderItems(): ResponseEntity<List<OrderItem>> = ResponseEntity.ok(orderItemService.findAll())

    @GetMapping("/{id}")
    fun getOrderItemById(@PathVariable id: Int): ResponseEntity<OrderItem> {
        val orderItem = orderItemService.findById(id)
        return if (orderItem != null) {
            ResponseEntity.ok(orderItem)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createOrderItem(@RequestBody orderItem: OrderItem): ResponseEntity<OrderItem> {
        val createdOrderItem = orderItemService.save(orderItem)
        return ResponseEntity.ok(createdOrderItem)
    }

    @PutMapping("/{id}")
    fun updateOrderItem(@PathVariable id: Int, @RequestBody orderItem: OrderItem): ResponseEntity<OrderItem> {
        val updatedOrderItem = orderItemService.update(id, orderItem)
        return if (updatedOrderItem != null) {
            ResponseEntity.ok(updatedOrderItem)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteOrderItem(@PathVariable id: Int): ResponseEntity<Void> {
        orderItemService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}
