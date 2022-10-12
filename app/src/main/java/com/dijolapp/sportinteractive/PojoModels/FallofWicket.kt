package com.dijolapp.sportinteractive.PojoModels

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class FallofWicket {
    @SerializedName("Batsman")
    @Expose
    var batsman: String? = null

    @SerializedName("Score")
    @Expose
    var score: String? = null

    @SerializedName("Overs")
    @Expose
    var overs: String? = null
}