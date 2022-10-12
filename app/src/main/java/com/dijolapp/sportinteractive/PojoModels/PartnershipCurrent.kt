package com.dijolapp.sportinteractive.PojoModels

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class PartnershipCurrent {
    @SerializedName("Runs")
    @Expose
    var runs: String? = null

    @SerializedName("Balls")
    @Expose
    var balls: String? = null

    @SerializedName("Batsmen")
    @Expose
    var batsmen: List<Batsman__1>? = null
}