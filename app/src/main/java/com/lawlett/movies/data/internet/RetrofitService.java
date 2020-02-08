package com.lawlett.movies.data.internet;


import com.lawlett.movies.data.internet.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET(".")
    Call<Example> getInfo(
              @Query("t") String title
            , @Query("apikey") String apikey);
}
