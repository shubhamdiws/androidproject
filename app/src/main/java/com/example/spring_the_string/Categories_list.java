package com.example.spring_the_string;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Categories_list extends AppCompatActivity {

    View cardview;

    List<list_model> list_modelList;
    RecyclerView rv_vol;
    String url = "https://jsonplaceholder.typicode.com/photos";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_list);

        rv_vol = (RecyclerView) findViewById(R.id.rec_ac);

        requestQueue = Volley.newRequestQueue(this);
        JsonResponse();
    }

    private void JsonResponse() {
        {
            list_modelList = new ArrayList<>();
            final JsonArrayRequest jsonArrayRequest;

            {
                jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONArray>() {

                            @Override
                            public void onResponse(JSONArray response) {


                                Log.d("fgf", String.valueOf(response));

                                try {
                                    for (int i = 0; i < 20; i++) {
                                        final JSONObject jsonObject = response.getJSONObject(i);
                                        int id = jsonObject.getInt("id");
                                       String url = jsonObject.getString("thumbnailUrl");
                                        list_model list_model=new list_model(id,url);
                                        list_modelList.add(list_model);

                                      Log.d("Data12",   url);


                                    }

                                    rv_vol.setLayoutManager( new GridLayoutManager(Categories_list.this, 2));
                                    rv_vol.setAdapter(new list_modelAdaptar(list_modelList, Categories_list.this));


                                } catch (JSONException e) {
                                    e.printStackTrace();

                                }


                            }


                        }, new Response.ErrorListener() {

                    public void onErrorResponse(VolleyError error) {
                        Log.d("Data12", String.valueOf(error.networkResponse));

                    }

                });




            }
            requestQueue.add(jsonArrayRequest);


        }
    }
}