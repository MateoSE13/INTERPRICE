package com.example.Interprice.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.sql.Date
import java.sql.Timestamp


@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(nullable = false)
    val fullname: String,

    @Column(unique = true, nullable = false)
    val email: String,

    @Column(nullable = false)
    val gender: String,

    @Column(nullable = false)
    val dateOfBirth: Date,

    @Column(nullable = false)
    val createdAt: Timestamp,

    @ManyToOne
    @JoinColumn(name = "country_id")
    val country: Country
)
