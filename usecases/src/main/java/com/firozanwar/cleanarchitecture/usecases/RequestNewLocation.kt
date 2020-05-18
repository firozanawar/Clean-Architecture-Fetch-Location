package com.firozanwar.cleanarchitecture.usecases

import com.firozanwar.cleanarchitecture.data.LocationsRepository
import com.firozanwar.cleanarchitecture.domain.Location

class RequestNewLocation(private val locationsRepository: LocationsRepository) {

    operator fun invoke(): List<Location> = locationsRepository.requestNewLocation()
}