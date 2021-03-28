package com.rana.mega_trust_jobs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class jobdetails extends AppCompatActivity {
TextView company_name;
TextView company_logo;
TextView job_title;
TextView job_type;
TextView job_url;
TextView job_desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobdetails);
    }
}