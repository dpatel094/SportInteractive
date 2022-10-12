package com.dijolapp.sportinteractive.PojoModels

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Batsman__1 {
    @SerializedName("Batsman")
    @Expose
    var batsman: String? = null

    @SerializedName("Runs")
    @Expose
    var runs: String? = null

    @SerializedName("Balls")
    @Expose
    var balls: String? = null
}