package com.dijolapp.sportinteractive.PojoModels

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Venue {
    @SerializedName("Id")
    @Expose
    var id: String? = null

    @SerializedName("Name")
    @Expose
    var name: String? = null
}