package com.insure.video.NetworkApi

import com.dijolapp.sportinteractive.PojoModels.ParentJson
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @GET(Urls.nzin01312019187360)
    fun getnzin01312019187360(): Call<String?>?

    @GET(Urls.sapk01222019186652)
    fun getsapk01222019186652(): Call<ParentJson?>?
}