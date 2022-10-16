package com.dijolapp.sportinteractive.PojoModels

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Inning {
    @SerializedName("Number")
    @Expose
    var number: String? = null

    @SerializedName("Battingteam")
    @Expose
    var battingteam: String? = null

    @SerializedName("Total")
    @Expose
    var total: String? = null

    @SerializedName("Wickets")
    @Expose
    var wickets: String? = null

    @SerializedName("Overs")
    @Expose
    var overs: String? = null

    @SerializedName("Runrate")
    @Expose
    var runrate: String? = null

    @SerializedName("Byes")
    @Expose
    var byes: String? = null

    @SerializedName("Legbyes")
    @Expose
    var legbyes: String? = null

    @SerializedName("Wides")
    @Expose
    var wides: String? = null

    @SerializedName("Noballs")
    @Expose
    var noballs: String? = null

    @SerializedName("Penalty")
    @Expose
    var penalty: String? = null

    @SerializedName("AllottedOvers")
    @Expose
    var allottedOvers: String? = null

    @SerializedName("Batsmen")
    @Expose
    var batsmen: List<Batsman>? = null

    @SerializedName("Partnership_Current")
    @Expose
    var partnershipCurrent: PartnershipCurrent? = null

    @SerializedName("Bowlers")
    @Expose
    var bowlers: List<Bowler>? = null

    @SerializedName("FallofWickets")
   @Expose
    var fallofWickets: List<FallofWicket>? = null
//
    @SerializedName("PowerPlay")
    @Expose
    var powerPlay: PowerPlay? = null

    @SerializedName("Target")
    @Expose
    var target: String? = null
}