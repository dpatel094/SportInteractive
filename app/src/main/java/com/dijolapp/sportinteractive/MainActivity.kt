package com.dijolapp.sportinteractive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dijolapp.sportinteractive.PojoModels.ParentJson
import com.dijolapp.sportinteractive.Retrofit.APIClient
import com.insure.video.NetworkApi.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GetDataFromApi()
    }

    fun GetDataFromApi(){
        val apiInterface: Api? = APIClient.client!!.create(Api::class.java)

        val call: Call<ParentJson?>? = apiInterface!!.getsapk01222019186652()
        call!!.enqueue(object : Callback<ParentJson?> {
            override fun onResponse(call: Call<ParentJson?>, response: Response<ParentJson?>) {
                Log.i("onResponse",response.toString())
            }

            override fun onFailure(call: Call<ParentJson?>, t: Throwable) {
                Log.i("onFailure",t.toString())
            }

        })
    }
}