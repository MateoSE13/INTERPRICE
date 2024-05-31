package com.example.Interprice.service

import com.example.Interprice.entity.Product
import com.example.Interprice.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository:  ProductRepository) {

    fun findAll(): List<Product> = productRepository.findAll()

    fun findById(id: Int): Product? = productRepository.findById(id).orElse(null)

    fun save(product: Product): Product = productRepository.save(product)

    fun update(id: Int, updatedProduct: Product): Product? {
        return if (productRepository.existsById(id)) {
            productRepository.save(updatedProduct.copy(id = id))
        } else {
            null
        }
    }

    fun deleteById(id: Int) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id)
        }
    }
}
