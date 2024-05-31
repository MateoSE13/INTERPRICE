package com.example.Interprice.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.sql.Timestamp
import javax.annotation.processing.Generated


@Entity
@Table(name = "merchant")
data class Merchant(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(nullable = false)
    val merchantName: String,

    @Column(nullable = false)
    val createdAt: Timestamp,

    @Column(nullable = false)
    val adminId: Long,

    @ManyToOne
    @JoinColumn(name = "country_id")
    val country: Country
)