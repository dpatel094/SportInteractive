package com.dijolapp.sportinteractive.Utils

import android.content.Context
import java.util.*

 class Utils {
    val MyPREFERENCES = "SportInteractive"
    fun savejson(productJson: String?, context: Context,jsonobjectName : String) {
        val sharedpreferences = context.getSharedPreferences(
            MyPREFERENCES,
            Context.MODE_PRIVATE
        )
        val editor = sharedpreferences.edit()
        editor.putString( productJson,jsonobjectName)
        editor.commit()
    }

    fun getjson(context: Context,jsonobjectName : String): String? {
        val getSahrePred = context.getSharedPreferences(
           MyPREFERENCES,
            Context.MODE_PRIVATE
        )
        return getSahrePred.getString(jsonobjectName, "")!!

    }

}