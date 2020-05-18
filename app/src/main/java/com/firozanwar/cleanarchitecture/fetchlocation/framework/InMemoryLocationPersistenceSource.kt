package com.firozanwar.cleanarchitecture.fetchlocation.framework

import com.firozanwar.cleanarchitecture.data.LocationPersistenceSource
import com.firozanwar.cleanarchitecture.domain.Location

class InMemoryLocationPersistenceSource : LocationPersistenceSource {

    private var locations: List<Location> = emptyList()

    override fun getPersistedLocations(): List<Location> = locations

    override fun saveNewLocation(location: Location) {
        locations = locations + location
    }
}