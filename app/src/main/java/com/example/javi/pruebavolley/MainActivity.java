package com.example.javi.pruebavolley;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView myRecyclerView;
    RequestQueue queue;
    String url;
    ArrayList<Item> aItems;
    private String TAG = "LogsAndroid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.MyToolbar);
        myRecyclerView = (RecyclerView) findViewById(R.id.MyRecyclerView);
        url ="https://dl.dropbox.com/s/8i4bgfwz7dxw15q/TiempoBueno.json?dl=0";
        aItems = new ArrayList<Item>();
        queue = Volley.newRequestQueue(this);

        obtenerDatos();

        Log.d(TAG, aItems.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.about_action:

                Toast.makeText(this, "Has Pulsado Acerca de", Toast.LENGTH_SHORT).show();
                break;

            case R.id.refresh_action:

                Toast.makeText(this, "Has pulsado recargar datos", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);

    }

    public void obtenerDatos() {

        final StringRequest stringRq = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e(TAG, response.toString());

                try {

                    JSONObject obj = new JSONObject(response);
                    JSONArray array = obj.getJSONArray("Tiempo");

                    for (int a = 0; a < array.length(); a++){

                        JSONObject objselected = array.getJSONObject(a);
                        String sCiud = objselected.getString("Ciudad");
                        String sTemp = objselected.getString("Temperatura");
                        String sPred = objselected.getString("Pred");
                        Item itemselected = new Item(sCiud, sTemp, sPred, getApplicationContext());
                        aItems.add(itemselected);

                    }

                }
                catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRq);

    }

}




