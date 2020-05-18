package com.firozanwar.cleanarchitecture.usecases

import com.firozanwar.cleanarchitecture.data.LocationsRepository
import com.firozanwar.cleanarchitecture.domain.Location

class GetLocations(private val locationRepository: LocationsRepository) {

    operator fun invoke(): List<Location> = locationRepository.getSavedLocations()
}