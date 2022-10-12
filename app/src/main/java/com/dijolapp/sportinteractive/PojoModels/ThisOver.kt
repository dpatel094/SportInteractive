package com.dijolapp.sportinteractive.PojoModels

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class ThisOver {
    @SerializedName("T")
    @Expose
    var t: String? = null

    @SerializedName("B")
    @Expose
    var b: String? = null
}