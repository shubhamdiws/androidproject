package com.example.spring_the_string;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import java.util.List;

public class list_modelAdaptar extends RecyclerView.Adapter<list_modelAdaptar.ViewHolder> {

    List<list_model>list_modelList;
    Context context;

    public list_modelAdaptar(List<list_model> list_modelList, Context mainActivity) {
        this.context = mainActivity;
        this.list_modelList = list_modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final list_model list_model=list_modelList.get(position);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,TabActivity.class));  // <--- here
            }
        });



        holder.id.setText(String.valueOf(list_model.id));
//        Picasso.with(context).load("https://via.placeholder.com/300.png").fit().centerCrop()
//                .placeholder(R.mipmap.ic_launcher)
//                .error(R.drawable.coffee)
//                .into(holder.image);

        Glide.with(context)
                .load("https://api.androidhive.info/images/sample.jpg")
                .into(holder.image);

//        Glide.with(context)
//                .load("https://via.placeholder.com/300.png")
//                .override(100, 200)
//                .fitCenter() // scale to fit entire image within ImageView
//                .into(holder.image);

  //      Glide.with(context).load(list_model.image).placeholder(R.drawable.coffee).dontAnimate().into(holder.image);


    }

    @Override
    public int getItemCount() {
        return list_modelList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView id;
        ImageView image;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id=itemView.findViewById(R.id.test_name);
            image=itemView.findViewById(R.id.img_test);
            cardView=itemView.findViewById(R.id.cv_hp);


        }


    }
}
