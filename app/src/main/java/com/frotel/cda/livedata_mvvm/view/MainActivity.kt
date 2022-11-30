package com.frotel.cda.livedata_mvvm.view

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.frotel.cda.livedata_mvvm.databinding.ActivityMainBinding
import com.frotel.cda.livedata_mvvm.modelview.ViewModelCounter
import com.frotel.cda.livedata_mvvm.modelview.ViewModelMain
import kotlinx.coroutines.newFixedThreadPoolContext

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val ViewModelMain:ViewModelMain by viewModels()
    private val ViewModelCounter:ViewModelCounter by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvA.setText(ViewModelMain.getValuA().toString())
        binding.tvB.setText(ViewModelMain.getValuB().toString())

        binding.buttonA.setOnClickListener{
           var a= ViewModelMain.incA()
            binding.tvA.setText(a.toString() )
        }


        binding.buttonB.setOnClickListener{
            var b= ViewModelMain.incB()
            binding.tvB.setText(b.toString())
        }

        binding.btStart.setOnClickListener{
            ViewModelCounter.startCounter()
        }


        ViewModelCounter.getState().observe(this, Observer {
            if (it){
                binding.tvcounter.text = "End Counter"
            }
        })
        ViewModelCounter.getCounter().observe(this, Observer {
            binding.tvcounter.text = it.toString()
        }



        )

    }


}