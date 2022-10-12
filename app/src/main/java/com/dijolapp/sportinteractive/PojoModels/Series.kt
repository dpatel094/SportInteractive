package com.dijolapp.sportinteractive.PojoModels

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Series {
    @SerializedName("Id")
    @Expose
    var id: String? = null

    @SerializedName("Name")
    @Expose
    var name: String? = null

    @SerializedName("Status")
    @Expose
    var status: String? = null

    @SerializedName("Tour")
    @Expose
    var tour: String? = null

    @SerializedName("Tour_Name")
    @Expose
    var tourName: String? = null
}