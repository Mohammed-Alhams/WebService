package com.example.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView tvRes;
    Button btnReq;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRes = findViewById(R.id.tvRes);
        btnReq = findViewById(R.id.btnReq);

        requestQueue = Volley.newRequestQueue(this);

        btnReq.setOnClickListener(v->{
            sendRequest();
        });
    }

    private void sendRequest() {

        String url = "https://jsonplaceholder.typicode.com/posts/2";

        final JSONObject[] jsonObject = new JSONObject[1];
        int n = Method.GET;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Method.GET, url, jsonObject[0], new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                tvRes.setText(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvRes.setText(error.getMessage());

            }

        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();

            }
        };



        requestQueue.add(jsonObjectRequest);
    }
}