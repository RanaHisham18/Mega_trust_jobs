package com.rana.mega_trust_jobs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyviewHolder> {
    private Context mcontext;
    private ArrayList<jobmodel> job_list;

    public Myadapter(Context context, ArrayList list) {
        mcontext = context;
        job_list = list;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(mcontext).inflate(R.layout.itemlist, parent, false);
        return new MyviewHolder(V);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        jobmodel currentitem = job_list.get(position);
        holder.name.setText(currentitem.company);
        holder.job_title.setText(currentitem.title);
        Glide
                .with(mcontext)
                .load(currentitem.company_logo)
                .centerCrop()
                .into(holder.imageView);
//        Picasso.get().load(currentitem.company_url).fit().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (job_list != null) {
            count = job_list.size();
        }
        return count;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView name;
        private TextView job_title;
        private String image_url;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView_com_name);
            job_title = itemView.findViewById(R.id.textView_job_title);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
