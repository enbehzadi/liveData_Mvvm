package com.frotel.cda.livedata_mvvm.modelview

import android.os.Bundle
import android.os.CountDownTimer
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.frotel.cda.livedata_mvvm.databinding.ActivityMainBinding

class ViewModelCounter : ViewModel() {

  private var A = 0
  private var B = 0

  private var counter : MutableLiveData<Int> = MutableLiveData()
  private var state : MutableLiveData<Boolean> =MutableLiveData()

 fun startCounter(){
     var time=10000
     val timer=object:CountDownTimer(time.toLong(),1000){
     override fun onTick(millisUntilFinished: Long) {
      val time=millisUntilFinished/1000
       counter.value=time.toInt()
     }

     override fun onFinish() {
       state.value=true
     }
   }
   timer.start()
 }

    fun getCounter(): MutableLiveData<Int> {
        return counter
    }

    fun getState(): MutableLiveData<Boolean> {
        return state
    }
}