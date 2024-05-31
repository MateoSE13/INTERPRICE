package com.example.Interprice.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "country")
data class Country(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "code", unique = true, nullable = false)
    var code: String,

    @Column(name = "country_name", nullable = false)
    var countryName: String,

    @Column(name = "continent_name", nullable = false)
    var continentName: String
)