package com.example.activitiesandintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_person_entry.*

lateinit var passedIntent: Intent

class PersonEntryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_entry)

        passedIntent = intent
    }

    fun addPersonToList(view: View)
    {
        val firstName = etFirstNameInput.text.toString()
        val lastName = etLastNameInput.text.toString()
        val birthDate = etBirthDateInput.text.toString()
        val occupation = etOcupationInput.text.toString()
        val userEnteredPerson = Person(firstName, lastName, birthDate, occupation)

        passedIntent.putExtra("Person", userEnteredPerson)
        setResult(321, passedIntent)
        finish()
    }
}
