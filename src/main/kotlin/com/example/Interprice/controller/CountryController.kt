package com.example.Interprice.controller

import com.example.Interprice.entity.Country
import com.example.Interprice.service.CountryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/country")
class CountryController(private val countryService: CountryService) {

    @GetMapping("/{id}")
    fun getCountryById(@PathVariable id: Int): ResponseEntity<Country> {
        val country = countryService.getCountryById(id)
        return if (country != null) {
            ResponseEntity.ok(country)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createCountry(@RequestBody country: Country): ResponseEntity<Country> {
        val createdCountry = countryService.createCountry(country)
        return ResponseEntity.ok(createdCountry)
    }

    @PutMapping("/{id}")
    fun updateCountry(@PathVariable id: Int, @RequestBody country: Country): ResponseEntity<Country> {
        val updatedCountry = countryService.updateCountry(id, country)
        return if (updatedCountry != null) {
            ResponseEntity.ok(updatedCountry)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteCountry(@PathVariable id: Int): ResponseEntity<Void> {
        countryService.deleteCountry(id)
        return ResponseEntity.noContent().build()
    }
}
