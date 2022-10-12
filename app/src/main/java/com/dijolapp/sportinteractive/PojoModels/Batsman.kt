package com.dijolapp.sportinteractive.PojoModels

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Batsman {
    @SerializedName("Batsman")
    @Expose
    var batsman: String? = null

    @SerializedName("Runs")
    @Expose
    var runs: String? = null

    @SerializedName("Balls")
    @Expose
    var balls: String? = null

    @SerializedName("Fours")
    @Expose
    var fours: String? = null

    @SerializedName("Sixes")
    @Expose
    var sixes: String? = null

    @SerializedName("Dots")
    @Expose
    var dots: String? = null

    @SerializedName("Strikerate")
    @Expose
    var strikerate: String? = null

    @SerializedName("Dismissal")
    @Expose
    var dismissal: String? = null

    @SerializedName("Howout")
    @Expose
    var howout: String? = null

    @SerializedName("Bowler")
    @Expose
    var bowler: String? = null

    @SerializedName("Fielder")
    @Expose
    var fielder: String? = null

    @SerializedName("Isonstrike")
    @Expose
    var isonstrike: Boolean? = null
}