package com.example.Interprice.repository

import com.example.Interprice.entity.Merchant
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MerchantRepository : JpaRepository<Merchant, Int>
