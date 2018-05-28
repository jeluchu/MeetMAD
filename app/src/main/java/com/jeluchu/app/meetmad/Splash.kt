package com.jeluchu.app.meetmad

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity


@SuppressLint("Registered")
class Splash : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        /** Creates a count down timer, which will be expired after 5000 milliseconds  */
        object : CountDownTimer(2000, 1000) {

            /** This method will be invoked on finishing or expiring the timer  */
            override fun onFinish() {
                /** Creates an intent to start new activity  */
                val intent = Intent(baseContext, MainActivity::class.java)

                // COMIENZA EL PROCESO
                startActivity(intent)

                //  FINALIZA Y REDIRIGE AL MAIN ACTIVITY
                finish()

            }

            override fun onTick(millisUntilFinished: Long) {

            }
        }.start()

    }
}