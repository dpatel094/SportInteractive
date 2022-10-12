package com.dijolapp.sportinteractive.Retrofit


import retrofit2.Retrofit
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.insure.video.NetworkApi.Urls
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object APIClient {
    private var retrofit: Retrofit? = null

    //.addConverterFactory(ScalarsConverterFactory.create())
    //.addConverterFactory(GsonConverterFactory.serializeNulls().create(gson))
    val client: Retrofit?
        get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client: OkHttpClient = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.DAYS)
                .writeTimeout(1, TimeUnit.DAYS)
                .readTimeout(1, TimeUnit.DAYS)
                .addInterceptor(interceptor).build()
            val gson = GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create()
            retrofit = Retrofit.Builder()
                .baseUrl(Urls.BASE_URL) //.addConverterFactory(ScalarsConverterFactory.create())
                //.addConverterFactory(GsonConverterFactory.serializeNulls().create(gson))
                .addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create()
                    )
                ).client(client)
                .build()
            return retrofit
        }
}