package com.example.Interprice.controller

import com.example.Interprice.entity.Product
import com.example.Interprice.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(private val productService:  ProductService) {

    @GetMapping
    fun getAllProducts(): ResponseEntity<List<Product>> = ResponseEntity.ok(productService.findAll())

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Int): ResponseEntity<Product> {
        val product = productService.findById(id)
        return if (product != null) {
            ResponseEntity.ok(product)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createProduct(@RequestBody product: Product): ResponseEntity<Product> {
        val createdProduct = productService.save(product)
        return ResponseEntity.ok(createdProduct)
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Int, @RequestBody product: Product): ResponseEntity<Product> {
        val updatedProduct = productService.update(id, product)
        return if (updatedProduct != null) {
            ResponseEntity.ok(updatedProduct)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Int): ResponseEntity<Void> {
        productService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}
