package com.firozanwar.cleanarchitecture.data

import com.firozanwar.cleanarchitecture.domain.Location

/**
 * As you can see, this layer is using the domain layer. An outer layer can use the inner layers (but not the other way round).
 */
class LocationsRepository(
    private val locationPersistanceSource: LocationPersistenceSource,
    private val deviceLocationSource: DeviceLocationSource
) {

    fun getSavedLocations(): List<Location> = locationPersistanceSource.getPersistedLocations()

    fun requestNewLocation(): List<Location> {
        val newLocation = deviceLocationSource.getDeviceLocation()
        locationPersistanceSource.saveNewLocation(newLocation)
        return getSavedLocations()
    }
}

interface LocationPersistenceSource {

    fun getPersistedLocations(): List<Location>
    fun saveNewLocation(location: Location)
}

interface DeviceLocationSource {

    fun getDeviceLocation(): Location
}