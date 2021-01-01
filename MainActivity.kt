package com.example.theclickergame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    var money=0
    var robortcount=0
    var clickpower=1
    var isenabled=false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickButton.setOnClickListener {
            var clickMultiplier : Int
            if(isenabled){
                clickMultiplier=2
            } else
            {
                clickMultiplier=1
            }
            var clickWorth = clickpower * (robortcount + 1) * clickMultiplier
            money+= clickWorth
            moneyText.text="$$money"
        }
        clickPowerButton.setOnClickListener {
            if(money>=100){
            clickpower+=1
            clickPowerText.text="CLICK POWER : $$clickpower"
                money-=100
                moneyText.text="$$money"
            }
        }
        robotButton.setOnClickListener{
            if(money>=1000)
            {
                robortcount+=1
                robotText.text="ROBORT COUNT: $$robortcount"
                money-=1000
                moneyText.text="$$money"
            }
        }
        doubleBonusButton.setOnClickListener {
            if(money>=5000)
            {
              //  robortcount+=1
                  isenabled=true
                doubleBonusText.text="DOUBLE BONUS: ACTIVE"
                money-=5000
                moneyText.text="$$money"
            }
        }
    }
}
