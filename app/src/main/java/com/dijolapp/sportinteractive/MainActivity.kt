package com.dijolapp.sportinteractive

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.dijolapp.sportinteractive.PojoModels.Matchdetail
import com.dijolapp.sportinteractive.Retrofit.APIClient
import com.dijolapp.sportinteractive.Utils.Utils
import com.google.gson.Gson
import com.insure.video.NetworkApi.Api
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    var utils: Utils? = null
    var match_name: TextView? = null
    var Venue_Name: TextView? = null
    var Match_Status: TextView? = null
    var Result_Winmargin: TextView? = null
    var Status: TextView? = null
    var cardview_id: CardView? = null

    var team_home : String? = null
    var team_away : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        utils = Utils()
        match_name = findViewById(R.id.match_name)
        Venue_Name = findViewById(R.id.Venue_Name)
        Match_Status = findViewById(R.id.Match_Status)
        Result_Winmargin = findViewById(R.id.Result_Winmargin)
        Status = findViewById(R.id.Status)
        cardview_id = findViewById(R.id.cardview_id)

        GetDataFromApi()

        cardview_id!!.setOnClickListener {
            val i = Intent(this, SecondActivity::class.java)
            i.putExtra("team_home",team_home)
            i.putExtra("team_away",team_away)
            startActivity(i)
        }
    }

    fun GetDataFromApi() {
        val apiInterface: Api? = APIClient.client!!.create(Api::class.java)

        val call: Call<String?>? = apiInterface!!.getsapk01222019186652()
        call!!.enqueue(object : Callback<String?> {
            override fun onResponse(call: Call<String?>, response: Response<String?>) {
                if (response.isSuccessful) {
                    val jsonResponse = response.body();
                    val response = JSONObject(jsonResponse)

                    val match = response.get("Matchdetail")
                    if (!match.toString().isEmpty()) {
                        val nuggets = response.get("Nuggets")
                        val innings = response.get("Innings")
                        val teams = response.get("Teams")
                        val notes = response.get("Notes")

                        Log.i("match", match.toString())
                        Log.i("nuggets", nuggets.toString())
                        Log.i("innings", innings.toString())
                        Log.i("teams", teams.toString())
                        Log.i("notes", notes.toString())

                        utils!!.savejson("Matchdetail", this@MainActivity, match.toString())
                        utils!!.savejson("Nuggets", this@MainActivity, nuggets.toString())
                        utils!!.savejson("Innings", this@MainActivity, innings.toString())
                        utils!!.savejson("Teams", this@MainActivity, teams.toString())
                        utils!!.savejson("Notes", this@MainActivity, notes.toString())

                        showOnUi()
                    }
                }

            }

            override fun onFailure(call: Call<String?>, t: Throwable) {
                Log.i("onFailure", t.toString())
            }

        })
    }

    @SuppressLint("SetTextI18n")
    fun showOnUi() {
        var getsharepre = utils!!.getjson(this, "Matchdetail")
        val gson = Gson()
        val matchdetail: Matchdetail = gson.fromJson(
            getsharepre,
            Matchdetail::class.java
        )
        match_name!!.text = "Match Name : " + matchdetail.series!!.name.toString()
        Venue_Name!!.text = "Venue Name : " + matchdetail.venue!!.name.toString()
        Match_Status!!.text = "Match Status : " + matchdetail.status.toString()
        Result_Winmargin!!.text = "Result : " + matchdetail.result.toString()

        Status!!.text = "Status : " + matchdetail.series!!.status.toString()
        team_away = matchdetail.teamAway
        team_home = matchdetail.teamHome

        Log.i("Matchname", matchdetail.series!!.name.toString())
        Log.i("Status", matchdetail.series!!.status.toString())
        Log.i("Tour_Name", matchdetail.series!!.tourName.toString())
        Log.i("Venue_Name", matchdetail.venue!!.name.toString())
        Log.i("Match_Status", matchdetail.status.toString())
        Log.i("Player_Match", matchdetail.playerMatch.toString())
        Log.i("Result", matchdetail.result.toString())
        Log.i("Winmargin", matchdetail.winmargin.toString())
    }
}