package com.dijolapp.sportinteractive.PojoModels

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Batting__1 {
    @SerializedName("Style")
    @Expose
    var style: String? = null

    @SerializedName("Average")
    @Expose
    var average: String? = null

    @SerializedName("Strikerate")
    @Expose
    var strikerate: String? = null

    @SerializedName("Runs")
    @Expose
    var runs: String? = null
}