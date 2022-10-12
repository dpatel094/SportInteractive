package com.dijolapp.sportinteractive.PojoModels

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class PowerPlay {
    @SerializedName("PP1")
    @Expose
    var pp1: String? = null

    @SerializedName("PP2")
    @Expose
    var pp2: String? = null
}