package com.example.Interprice.service

import com.example.Interprice.entity.Country
import com.example.Interprice.repository.CountryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class CountryService(private val countryRepository: CountryRepository) {

    fun getCountryById(id: Int): Country? {
        return countryRepository.findById(id).orElse(null)
    }

    fun createCountry(country: Country): Country {
        return countryRepository.save(country)
    }

    fun updateCountry(id: Int, countryDetails: Country): Country? {
        val existingCountry = countryRepository.findById(id).orElse(null) ?: return null
        existingCountry.code = countryDetails.code
        existingCountry.countryName = countryDetails.countryName
        existingCountry.continentName = countryDetails.continentName
        return countryRepository.save(existingCountry)
    }

    fun deleteCountry(id: Int) {
        countryRepository.deleteById(id)
    }
}