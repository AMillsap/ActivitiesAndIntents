package com.example.activitiesandintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_person_result.*
import java.io.Serializable


class PersonResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_result)

        val personList = intent.getParcelableArrayListExtra<Person>("List")
        tvPersonArrayOutput.text = personList.toString()
    }
}
