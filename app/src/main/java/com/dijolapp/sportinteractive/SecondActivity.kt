package com.dijolapp.sportinteractive

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dijolapp.sportinteractive.Adapter.PlayerListApdater
import com.dijolapp.sportinteractive.PojoModels.Inning
import com.dijolapp.sportinteractive.Utils.Utils
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class SecondActivity : AppCompatActivity() {
    var utils: Utils? = null
    var team_home: String? = null
    var teamhome_full: String? = null
    var teamhome_short: String? = null
    var team_away: String? = null
    var teamaway_full: String? = null
    var teamaway_short: String? = null
    var teamhome: Button? = null
    var teamaway: Button? = null
    var teamtwo_name: TextView? = null
    var teamone_name: TextView? = null
    var all: Button? = null
    var recyclerView: RecyclerView? = null
    var recyclerView2: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        utils = Utils()

        all = findViewById(R.id.all)
        teamhome = findViewById(R.id.teamone)
        teamaway = findViewById(R.id.teamtwo)
        teamtwo_name = findViewById(R.id.teamtwo_name)
        teamone_name = findViewById(R.id.teamone_name)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView2 = findViewById(R.id.recyclerView2)
        val intent = intent
        team_home = intent.getStringExtra("team_home")
        team_away = intent.getStringExtra("team_away")

        var getinnings = utils!!.getjson(this, "Innings")
        var getteams = utils!!.getjson(this, "Teams")
        val gson = Gson()

        val jsona = JSONArray(getinnings)
        val team_away_playerid: ArrayList<String> = ArrayList()
        val team_home_payerid: ArrayList<String> = ArrayList()

        val team_away_playerdetail: ArrayList<String> = ArrayList()
        val team_home_payerdetail: ArrayList<String> = ArrayList()


        val team_All_payerdetail: ArrayList<String> = ArrayList()

        val myPojoArray: Array<Inning>? = gson.fromJson(jsona.toString(), Array<Inning>::class.java)
        for (i in myPojoArray!!.indices) {
            for (ii in myPojoArray!![i].batsmen!!.indices) {
                if (i == 0) {
                    team_away_playerid.add(myPojoArray[i].batsmen!![ii].batsman!!)

                } else {
                    team_home_payerid.add(myPojoArray[i].batsmen!![ii].batsman!!)
                }

            }
        }

        for (i in team_home_payerid.indices) {

            val response = JSONObject(getteams)
            val match = response.get(team_home)

            val responsee = JSONObject(match.toString())
            teamhome_full = responsee.get("Name_Full").toString()
            teamhome_short = responsee.get("Name_Short").toString()
            val players = responsee.get("Players")

            val responseee = JSONObject(players.toString())
            val values = team_home_payerid[i]
            val matchhh = responseee.get(values)
            team_home_payerdetail.add(matchhh.toString())
            team_All_payerdetail.add(matchhh.toString())
        }
        for (i in team_away_playerid.indices) {
            val response = JSONObject(getteams)
            val match = response.get(team_away)
            val responsee = JSONObject(match.toString())
            teamaway_full = responsee.get("Name_Full").toString()
            teamaway_short = responsee.get("Name_Short").toString()
            val matchh = responsee.get("Players")
            val responseee = JSONObject(matchh.toString())
            val values = team_away_playerid[i]
            val matchhh = responseee.get(values)
            team_away_playerdetail.add(matchhh.toString())
            team_All_payerdetail.add(matchhh.toString())
        }
        var getTeams = utils!!.getjson(this, "Teams")

        calladapter(team_home_payerdetail)


        teamhome!!.text = teamhome_short
        teamaway!!.text = teamaway_short
        teamhome!!.setOnClickListener {
            calladapter(team_home_payerdetail)

        }
        teamaway!!.setOnClickListener { calladapter(team_away_playerdetail) }
        all!!.setOnClickListener {
            teamone_name!!.visibility = View.VISIBLE
            teamtwo_name!!.visibility = View.VISIBLE
            teamtwo_name!!.text = teamhome_full
            teamone_name!!.text = teamaway_full

            calladapter(team_away_playerdetail)
            calladapter2(team_home_payerdetail)
        }
    }

    fun calladapter(team_home_payerdetail: ArrayList<String>) {

        val adapter = PlayerListApdater(this, team_home_payerdetail)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.adapter = adapter
    }

    fun calladapter2(team_home_payerdetail: ArrayList<String>) {
        val adapter = PlayerListApdater(this, team_home_payerdetail)
        recyclerView2!!.setHasFixedSize(true)
        recyclerView2!!.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView2!!.adapter = adapter
    }
}