package com.example.activitiesandintents

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(var firstName : String,
                  var lastName : String,
                  var birthDate : String,
                  var occupation : String) : Parcelable