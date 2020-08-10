package com.example.restaurantmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food__detail.*

import kotlinx.android.synthetic.main.food_ticket.ivImage
import kotlinx.android.synthetic.main.food_ticket.tvName

class Food_Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food__detail)
        var bundle = intent.extras
        ivImage.setImageResource(bundle!!.getInt("image"))
        tvName.text = (bundle!!.getString("name"))
        tvDes.text = bundle!!.getString("des")

    }
}