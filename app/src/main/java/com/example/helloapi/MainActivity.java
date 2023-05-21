package com.example.helloapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Response.Listener<JSONObject>, Response.ErrorListener {

    private TextView tvName;
    private TextView tvTime;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRequest = this.findViewById(R.id.btnRequest);

        this.tvName = this.findViewById(R.id.tvName);
        this.tvTime = this.findViewById(R.id.tvTime);

        btnRequest.setOnClickListener(this);

        this.requestQueue = Volley.newRequestQueue(this);

    }

    @Override
    public void onClick(View view) {
//        StringRequest sr = new StringRequest(
//                Request.Method.GET,
//                "https://mgm.ub.ac.id/hello.php?name=Bagas",
//                this,
//                this
//        );

        Map<String, String> data = new HashMap<>();
        data.put("name", "Bagas12");
        JSONObject jsonData = new JSONObject(data);

        JsonObjectRequest sr = new JsonObjectRequest(
                Request.Method.POST,
                "https://mgm.ub.ac.id/hello.php",
                jsonData, // ini jsonRequest
                this,
                this
        );
        this.requestQueue.add(sr);
    }

//    @Override
//    public void onResponse(String response) {
//        Toast.makeText(this, response, Toast.LENGTH_LONG).show();
//    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this, response.toString(), Toast.LENGTH_LONG).show();
        try {
            this.tvName.setText(response.getString("name"));
            this.tvTime.setText(response.getString("time"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
//        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        Toast.makeText(this, error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
    }
}