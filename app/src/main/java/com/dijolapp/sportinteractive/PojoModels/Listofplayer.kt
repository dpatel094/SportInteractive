package com.dijolapp.sportinteractive.PojoModels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Listofplayer {
    var Position: String? = null
    var Name_Full: String? = null
    var Iscaptain: Boolean? = false
    var Iskeeper: Boolean? = false
    var Batting: PlayerBatting? = null
    var Bowling: PlayerBowling? = null
}