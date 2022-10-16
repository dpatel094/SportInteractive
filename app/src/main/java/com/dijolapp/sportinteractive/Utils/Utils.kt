package com.dijolapp.sportinteractive.Utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.dijolapp.sportinteractive.PojoModels.Listofplayer
import com.dijolapp.sportinteractive.PojoModels.PlayerBatting
import com.dijolapp.sportinteractive.PojoModels.PlayerBowling
import com.dijolapp.sportinteractive.R
import com.google.gson.Gson
import org.json.JSONObject

class Utils {
    val MyPREFERENCES = "SportInteractive"
    fun savejson(productJson: String?, context: Context, jsonobjectName: String) {
        val sharedpreferences = context.getSharedPreferences(
            MyPREFERENCES, Context.MODE_PRIVATE
        )
        val editor = sharedpreferences.edit()
        editor.putString(productJson, jsonobjectName)
        editor.commit()
    }

    fun getjson(context: Context, jsonobjectName: String): String? {
        val getSahrePred = context.getSharedPreferences(
            MyPREFERENCES, Context.MODE_PRIVATE
        )
        return getSahrePred.getString(jsonobjectName, "")!!

    }

    fun getjsonobject(response: JSONObject): Listofplayer {
        val gson = Gson()
        val matchdetail: Listofplayer = gson.fromJson(
            response.toString(), Listofplayer::class.java
        )

        return matchdetail
    }

    var dialog: AlertDialog? = null
    fun showloadingDialog(context: Context, batting: String, bowling: String, playername: String) {
        val bowlingString = StringBuilder()
        val battingString = StringBuilder()
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)

        val customLayout: View = inflater.inflate(R.layout.player_dialog_, null)
        val player_name: TextView = customLayout.findViewById(R.id.player_name)
        val batting_txt: TextView = customLayout.findViewById(R.id.batting)
        val bowling_txt: TextView = customLayout.findViewById(R.id.bowling)


        val gson = Gson()
        val playerbatting: PlayerBatting = gson.fromJson(
            batting, PlayerBatting::class.java
        )
        val playerbowling: PlayerBowling = gson.fromJson(
            bowling, PlayerBowling::class.java
        )

        bowlingString.append("Bowling : " + "\n" + "Style : " + playerbowling.Style + "\n" + "Average : " + playerbowling.Average + "\n" + "Economyrate : " + playerbowling.Economyrate + "\n" + "Wickets : " + playerbowling.Wickets)
        battingString.append("Bowling : " + "\n" + "Style : " + playerbatting.Style + "\n" + "Average : " + playerbatting.Average + "\n" + "Strikerate : " + playerbatting.Strikerate + "\n" + "Runs : " + playerbatting.Runs)

        player_name.text = "Player Name : $playername"
        batting_txt.text = battingString.toString()
        bowling_txt.text = bowlingString.toString()


        builder.setView(customLayout)

        dialog = builder.create()
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog!!.show()

    }

    fun closeDialog() {
        if (dialog!!.isShowing) {
            dialog!!.dismiss()
        }
    }
}