package com.example.activitiesandintents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_emi.*

class EMIActivity : AppCompatActivity()
{
    var loanAmount = 0
    var interestRate = 0
    var monthlyPayment = 0
    var emiResult = 0
    lateinit var  loanAmountSlider : SeekBar
    lateinit var  intrestRateSlider : SeekBar
    lateinit var  monthlyPaymentSlider : SeekBar

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emi)
        loanAmountSlider = findViewById(R.id.sbLoanAmount) as SeekBar

        loanAmountSlider.setOnSeekBarChangeListener(object  : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean)
            {
                tvLoanOutput.text = progress.toString()
                loanAmount = progress
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        intrestRateSlider = findViewById(R.id.sbInterestRate) as SeekBar

        intrestRateSlider.setOnSeekBarChangeListener(object  : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean)
            {
                tvInterestOutput.text = progress.toString()
                interestRate = progress
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        monthlyPaymentSlider = findViewById(R.id.sbMonthlyInstalments) as SeekBar

        monthlyPaymentSlider.setOnSeekBarChangeListener(object  : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean)
            {
                tvMonthlyOutput.text = progress.toString()
                loanAmount = progress
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    fun calculateEMI(view: View)
    {
        emiResult = ((loanAmount * interestRate * Math.pow(1+interestRate.toDouble(),monthlyPayment.toDouble())) /
                (Math.pow((1+interestRate).toDouble(), (monthlyPayment-1).toDouble()))).toInt()
        tvOutputText.text = emiResult.toString()
    }


}