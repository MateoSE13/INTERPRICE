package com.example.Interprice.controller

import com.example.Interprice.entity.Merchant
import com.example.Interprice.service.MerchantService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/merchants")
class MerchantController(private val merchantService:  MerchantService) {

    @GetMapping
    fun getAllMerchants(): ResponseEntity<List<Merchant>> = ResponseEntity.ok(merchantService.findAll())

    @GetMapping("/{id}")
    fun getMerchantById(@PathVariable id: Int): ResponseEntity<Merchant> {
        val merchant = merchantService.findById(id)
        return if (merchant != null) {
            ResponseEntity.ok(merchant)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createMerchant(@RequestBody merchant: Merchant): ResponseEntity<Merchant> {
        val createdMerchant = merchantService.save(merchant)
        return ResponseEntity.ok(createdMerchant)
    }

    @PutMapping("/{id}")
    fun updateMerchant(@PathVariable id: Int, @RequestBody merchant: Merchant): ResponseEntity<Merchant> {
        val updatedMerchant = merchantService.update(id, merchant)
        return if (updatedMerchant != null) {
            ResponseEntity.ok(updatedMerchant)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteMerchant(@PathVariable id: Int): ResponseEntity<Void> {
        merchantService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}
