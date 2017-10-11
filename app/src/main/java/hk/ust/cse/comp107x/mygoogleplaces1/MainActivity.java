package hk.ust.cse.comp107x.mygoogleplaces1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

Button search;
        TextView searchTxt;
        ListView listPlace;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search=(Button) findViewById(R.id.button);
        searchTxt=(TextView) findViewById(R.id.textView);
        listPlace =(ListView) findViewById(R.id.listView);

        search.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        String url="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&type=restaurant&keyword=cruise&key=AIzaSyBIAa0kYCBEtmt1xWbikqhmq5IzPW5NvXo";
        executeWebService(url);
        }
        });
        }

        void executeWebService(String url) {
        RequestQueue queue = Volley.newRequestQueue(this);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
        new Response.Listener<String>() {
@Override
public void onResponse(String response) {

        try {

        JSONObject jsonObject = new JSONObject(response);
        JSONArray jsonArray = jsonObject.getJSONArray("results");
        //mTextView.setText(jsonArray.toString());

final PlaceModels[] placeModel;
        placeModel = new Gson().fromJson(jsonArray.toString(), PlaceModels[].class);
       Adapter_places movieAdapter = new Adapter_places(MainActivity.this, placeModel);
        listPlace.setAdapter(movieAdapter);
        listPlace.setOnItemClickListener(new AdapterView.OnItemClickListener() {

@Override
public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        }
        });
        } catch (JSONException e) {
        e.printStackTrace();
        }
        }
        }, new Response.ErrorListener() {
@Override
public void onErrorResponse(VolleyError error) {


        }
        });
        queue.add(stringRequest);
        }

    private class ErrorListener {
    }
}


