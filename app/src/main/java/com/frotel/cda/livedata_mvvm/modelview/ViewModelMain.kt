package com.frotel.cda.livedata_mvvm.modelview

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModel
import com.frotel.cda.livedata_mvvm.databinding.ActivityMainBinding

class ViewModelMain : ViewModel() {
  private var A = 0
  private var B = 0

  fun getValuA(): Int {
    return A
  }

  fun getValuB(): Int {
    return B
  }

  fun incA(): Int {
    A++
    return A
  }

  fun incB(): Int {
    B++
    return B
  }
}