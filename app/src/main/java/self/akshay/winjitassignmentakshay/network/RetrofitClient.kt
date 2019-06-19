package self.akshay.winjitassignmentakshay.network

import okhttp3.OkHttpClient

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory



fun getRetrofitInstance (debug: Boolean = true) =
    getRetrofitClient(setLoggingInterceptor(debug))




// sets http logging for debug mode only
private fun setLoggingInterceptor(debug: Boolean): OkHttpClient {

    val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
    val client = OkHttpClient.Builder()

    if (debug) {

        logger.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(logger)

    }


    return client.build()


}


private  fun  getRetrofitClient(client : OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl("https://my-json-server.typicode.com/akshay3015/fakeData/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

