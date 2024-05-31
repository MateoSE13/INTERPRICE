package com.example.Interprice.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal
import java.sql.Timestamp


@Entity
@Table(name = "product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(nullable = false)
    val description: String,

    @ManyToOne
    @JoinColumn(name = "merchant_id")
    val merchant: Merchant,

    @Column(nullable = false)
    val price: BigDecimal,

    @Column(nullable = false)
    val status: String,

    @Column(nullable = false)
    val createdAt: Timestamp
)