package com.dijolapp.sportinteractive.PojoModels

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class ParentJson {
    @SerializedName("Matchdetail")
    @Expose
    private var matchdetail: Matchdetail? = null

    @SerializedName("Nuggets")
    @Expose
    private var nuggets: List<String?>? = null

    @SerializedName("Innings")
    @Expose
    private var innings: List<Inning?>? = null



}