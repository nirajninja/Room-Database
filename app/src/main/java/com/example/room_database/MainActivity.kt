package com.example.room_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        thread {
            val db = Room.databaseBuilder(
                applicationContext,
                AppDb::class.java, "Employee-DB"
            ).build()
            var emp=Emp_Entity()
            emp.emp_id=33
            emp.emp_name="NILESH"
            emp.emp_post="emiem"
            db.empDao().saveEmp(emp)
            db.empDao().readEmp().forEach{
                Log.i("TAg","${it.emp_id}")
                Log.i("TAg","${it.emp_name}")
                Log.i("TAg","${it.emp_post}")

            }
        }
    }
}