package com.dijolapp.sportinteractive.PojoModels

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Officials {
    @SerializedName("Umpires")
    @Expose
    var umpires: String? = null

    @SerializedName("Referee")
    @Expose
    var referee: String? = null
}