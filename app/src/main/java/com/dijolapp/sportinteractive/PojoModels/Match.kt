package com.dijolapp.sportinteractive.PojoModels

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Match {
    @SerializedName("Livecoverage")
    @Expose
    var livecoverage: String? = null

    @SerializedName("Id")
    @Expose
    var id: String? = null

    @SerializedName("Code")
    @Expose
    var code: String? = null

    @SerializedName("League")
    @Expose
    var league: String? = null

    @SerializedName("Number")
    @Expose
    var number: String? = null

    @SerializedName("Type")
    @Expose
    var type: String? = null

    @SerializedName("Date")
    @Expose
    var date: String? = null

    @SerializedName("Time")
    @Expose
    var time: String? = null

    @SerializedName("Offset")
    @Expose
    var offset: String? = null

    @SerializedName("Daynight")
    @Expose
    var daynight: String? = null
}