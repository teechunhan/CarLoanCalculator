package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            calculateLoan();
        }

        buttonReset.setOnClickListener{
            resetInput();
        }
    }

    private fun calculateLoan() {
        val carPrice=editTextCarPrice.text.toString().toInt()
        val downPayment=editTextDownPayment.text.toString().toInt()
        val loanPeriod=editTextLoanPeriod.text.toString().toInt()
        val interestRate=editTextInterestRate.text.toString().toFloat()

        val carLoan = carPrice - downPayment
        val interest = carLoan * interestRate * loanPeriod
        val monthlyRepayment = (carLoan + interest) / loanPeriod / 12

        textViewLoan.setText("Loan = " + carLoan)
        textViewInterest.setText("Interest = " + interest)
        textViewMonthlyRepayment.setText("Monthly Repayment = " + monthlyRepayment)

    }

    private fun resetInput() {
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextInterestRate.setText("")
        editTextLoanPeriod.setText("")
        textViewLoan.text=getString(R.string.loan)
        textViewInterest.text=getString(R.string.interest)
        textViewMonthlyRepayment.text=getString(R.string.monthly_repayment)
    }
}
