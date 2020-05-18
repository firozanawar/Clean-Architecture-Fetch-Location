package com.firozanwar.cleanarchitecture.fetchlocation.ui

import com.firozanwar.cleanarchitecture.usecases.GetLocations
import com.firozanwar.cleanarchitecture.usecases.RequestNewLocation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.firozanwar.cleanarchitecture.domain.Location as DomainLocation

class MainPresenter(
    private var view: View?,
    private val getLocations: GetLocations,
    private val requestNewLocation: RequestNewLocation
) {

    interface View {
        fun renderLocations(locations: List<Location>)
    }

    fun onCreate() = GlobalScope.launch(Dispatchers.Main) {
        val locations = withContext(Dispatchers.IO) { getLocations() }
        view?.renderLocations(locations.map(DomainLocation::toPresentationModel))
    }

    fun newLocationClicked() = GlobalScope.launch(Dispatchers.Main) {
        val locations = withContext(Dispatchers.IO) { requestNewLocation() }
        view?.renderLocations(locations.map(DomainLocation::toPresentationModel))
    }

    fun onDestroy() {
        view = null
    }
}