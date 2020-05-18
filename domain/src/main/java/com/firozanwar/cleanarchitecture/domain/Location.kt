package com.firozanwar.cleanarchitecture.domain

import java.util.*

/**
 * Domain layer consist of Models
 *
 * Also known as business logic. These are the rules of your business.
* It contains all the business models.
* For instance, in a movies App, it could be the Movie class, the Subtitle class, etc.
 */
data class Location(val latitude: Double, val longitude: Double, val date: Date)
