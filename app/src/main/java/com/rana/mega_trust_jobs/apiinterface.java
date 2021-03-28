package com.rana.mega_trust_jobs;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface apiinterface {

    @GET("positions.json?description=api")
    Call<ArrayList<jobmodel>> getpost();

}
