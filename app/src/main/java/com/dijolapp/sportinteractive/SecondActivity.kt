package com.dijolapp.sportinteractive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dijolapp.sportinteractive.PojoModels.Batsman
import com.dijolapp.sportinteractive.PojoModels.Inning
import com.dijolapp.sportinteractive.PojoModels.Matchdetail
import com.dijolapp.sportinteractive.R
import com.dijolapp.sportinteractive.Utils.Utils
import com.google.gson.Gson
import org.json.JSONObject

class SecondActivity : AppCompatActivity() {
    var utils: Utils? = null
    var team_home : String? = null
    var team_away : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        utils = Utils()

        val intent = intent
        team_home = intent.getStringExtra("team_home")
        team_away = intent.getStringExtra("team_away")

        var getinnings = utils!!.getjson(this, "Innings")



        val responseinnings = JSONObject(getinnings)
        val matchinnings = responseinnings.get("Batsmen")
        val gson = Gson()
        val matchdetail: Batsman = gson.fromJson(
            matchinnings.toString(),
            Batsman::class.java
        )

        var getTeams = utils!!.getjson(this, "Teams")
    }
}