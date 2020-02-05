package com.example.activitiesandintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    var personList : ArrayList<Person> = ArrayList<Person>()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View)
    {
        when(view.id)
        {
            R.id.btnPicture ->
            {
                val intent = Intent(this, PictureActivity::class.java)
                startActivity(intent)
            }

            R.id.btnEMICalculator ->
            {
                val intent = Intent(this, EMIActivity::class.java)
                startActivity(intent)
            }
            R.id.btnGeneratePerson ->
            {
                val intent = Intent(this, PersonEntryActivity::class.java)
                startActivityForResult(intent, 123)
            }
            R.id.btnShowPerson ->
            {
                val intent = Intent(this, PersonResultActivity::class.java)

                intent.putParcelableArrayListExtra("List",personList)
                startActivity(intent)
            }
            R.id.btnCalendar ->
            {
                val intent = Intent(this, CalendarActivity::class.java)
                startActivity(intent)
            }
            R.id.btnWebpage ->
            {
                val intent = Intent(this, WebActivity::class.java)
                startActivity(intent)
            }


        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 123 && resultCode == 321)
        {
            personList.add(data?.getParcelableExtra<Person>("Person") as Person)
        }
    }
}
