package com.rana.mega_trust_jobs;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.JsonClass;

import java.io.Serializable;

@JsonClass(generateAdapter = true)
public class jobmodel  {

    public jobmodel(){}
    String id =null;
    String type=null;
    String url=null;
    String created_at=null;
    String company=null;
    String company_url=null;
    String location=null;
    String title=null;
    String description=null;
    String company_logo=null;
}
