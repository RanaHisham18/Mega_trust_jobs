package com.rana.mega_trust_jobs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class JobListActivity extends AppCompatActivity {

    public RecyclerView recyclerView;

    Myadapter adapter ;
    private ArrayList<jobmodel> Joblist;



//    public JobListActivity(TextView name, TextView jobtitle, String imageurl) {
//
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joblist);



        recyclerView = findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Joblist = new ArrayList<>();

        adapter = new Myadapter(this,Joblist);
        recyclerView.setAdapter(adapter);

        //mRequestQueue = Volley.newRequestQueue(this);



        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jobs.github.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        apiinterface apiinterface = retrofit.create(apiinterface.class);
        Call<ArrayList<jobmodel>> call = apiinterface.getpost();
        call.enqueue(new Callback<ArrayList<jobmodel>>() {
            @Override
            public void onResponse(Call<ArrayList<jobmodel>> call, Response<ArrayList<jobmodel>> response) {
                Joblist=response.body();
                Myadapter myadapter =new  Myadapter (JobListActivity.this,response.body());
                recyclerView.setAdapter(myadapter);
                myadapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<jobmodel>> call, Throwable t) {

                Log.d("TESTKKK",t.getMessage().toString());
            }
        });

    }
}