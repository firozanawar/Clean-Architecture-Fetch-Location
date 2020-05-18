package com.firozanwar.cleanarchitecture.fetchlocation.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.firozanwar.cleanarchitecture.data.LocationsRepository
import com.firozanwar.cleanarchitecture.fetchlocation.R
import com.firozanwar.cleanarchitecture.fetchlocation.framework.FakeLocationSource
import com.firozanwar.cleanarchitecture.fetchlocation.framework.InMemoryLocationPersistenceSource
import com.firozanwar.cleanarchitecture.usecases.GetLocations
import com.firozanwar.cleanarchitecture.usecases.RequestNewLocation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainPresenter.View {

    private val presenter: MainPresenter

    init {

        val persistence = InMemoryLocationPersistenceSource()
        val deviceLocation = FakeLocationSource()
        val locationsRepository = LocationsRepository(persistence, deviceLocation)
        presenter = MainPresenter(
            this,
            GetLocations(locationsRepository),
            RequestNewLocation(locationsRepository)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newLocationBtn.setOnClickListener { presenter.newLocationClicked() }

        presenter.onCreate()
    }

    override fun renderLocations(locations: List<Location>) {
        Log.d("FIROZ", "List is: " + locations);
    }
}
