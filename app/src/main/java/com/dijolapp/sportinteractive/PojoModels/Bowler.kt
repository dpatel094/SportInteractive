package com.dijolapp.sportinteractive.PojoModels

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Bowler {
    @SerializedName("Bowler")
    @Expose
    var bowler: String? = null

    @SerializedName("Overs")
    @Expose
    var overs: String? = null

    @SerializedName("Maidens")
    @Expose
    var maidens: String? = null

    @SerializedName("Runs")
    @Expose
    var runs: String? = null

    @SerializedName("Wickets")
    @Expose
    var wickets: String? = null

    @SerializedName("Economyrate")
    @Expose
    var economyrate: String? = null

    @SerializedName("Noballs")
    @Expose
    var noballs: String? = null

    @SerializedName("Wides")
    @Expose
    var wides: String? = null

    @SerializedName("Dots")
    @Expose
    var dots: String? = null

    @SerializedName("Isbowlingtandem")
    @Expose
    var isbowlingtandem: Boolean? = null

    @SerializedName("Isbowlingnow")
    @Expose
    var isbowlingnow: Boolean? = null

    @SerializedName("ThisOver")
    @Expose
    var thisOver: List<ThisOver>? = null
}