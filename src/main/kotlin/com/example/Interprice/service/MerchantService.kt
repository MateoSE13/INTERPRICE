package com.example.Interprice.service

import com.example.Interprice.entity.Merchant
import com.example.Interprice.repository.MerchantRepository
import org.springframework.stereotype.Service

@Service
class MerchantService(private val merchantRepository:  MerchantRepository) {

    fun findAll(): List<Merchant> = merchantRepository.findAll()

    fun findById(id: Int): Merchant? = merchantRepository.findById(id).orElse(null)

    fun save(merchant: Merchant): Merchant = merchantRepository.save(merchant)

    fun update(id: Int, updatedMerchant: Merchant): Merchant? {
        return if (merchantRepository.existsById(id)) {
            merchantRepository.save(updatedMerchant.copy(id = id))
        } else {
            null
        }
    }

    fun deleteById(id: Int) {
        if (merchantRepository.existsById(id)) {
            merchantRepository.deleteById(id)
        }
    }
}
