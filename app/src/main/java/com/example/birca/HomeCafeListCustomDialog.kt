package com.example.birca

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable

class HomeCafeListCustomDialog(context : Context) {

    private val dialog = Dialog(context)


    fun showDialog() {
        dialog.setContentView(R.layout.calendar_cafe_list)
       // dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

    }

}