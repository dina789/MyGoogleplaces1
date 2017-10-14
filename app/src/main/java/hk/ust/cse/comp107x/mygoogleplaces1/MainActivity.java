package hk.ust.cse.comp107x.mygoogleplaces1;

//AIzaSyB3eBGcB57xsUEM9zrpblxU-KvEhEKE1EA
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

Button search;
        TextView searchTxt;
        ListView listPlace;
        ProgressDialog progressDialog;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog=new ProgressDialog(MainActivity.this);
        search=(Button) findViewById(R.id.button);
        searchTxt=(TextView) findViewById(R.id.textView);
        listPlace =(ListView) findViewById(R.id.listView);

        search.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        GetPlacesFormatAPI getPlacesFormatAPI=new GetPlacesFormatAPI();
        String url="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&type=restaurant&keyword=cruise&key=AIzaSyB3eBGcB57xsUEM9zrpblxU-KvEhEKE1EA ";
        //executeWebService(url);
        getPlacesFormatAPI.execute(url);
        }
        });
        }






class  GetPlacesFormatAPI extends AsyncTask<String, Void, PlaceModels[]> {
        @Override
        protected void onPreExecute() {

            progressDialog.setMessage("Loading . . . ");
                progressDialog.show();
        }

        OkHttpClient client = new OkHttpClient();

        String run(String url) throws IOException {
                Request request = new Request.Builder()
                        .url(url)
                        .build();

                Response response = client.newCall(request).execute();
                return response.body().string();
        }

        @Override
        protected PlaceModels[] doInBackground(String... url) {

                // String url = "http://api.themoviedb.org/3/discover/movie?api_key=be32430c9f675ed7df41fbeda2a0525a&language=en-US&sort_by=" + sortByVarible + "&page=1";
//                executeWebService(url);
                try {
                        String s = run(url[0]);
                        Log.d("yarab", s);
                        JSONObject jsonObject = new JSONObject(s);
                        JSONArray jsonArray = jsonObject.getJSONArray("results");
                        //mTextView.setText(jsonArray.toString());

                        final PlaceModels[] PlaceModels;
                    PlaceModels = new Gson().fromJson(jsonArray.toString(), PlaceModels[].class);
                        return PlaceModels;
                } catch (IOException e) {
                        e.printStackTrace();
                } catch (JSONException e) {
                        e.printStackTrace();
                }

                return null;


        }

        @Override
        protected void onPostExecute(final PlaceModels[] PlaceModels) {
                progressDialog.dismiss();
                if (PlaceModels != null) {


                        Adapter_places PlaceAdapter = new Adapter_places(MainActivity.this,PlaceModels);
                    listPlace.setAdapter(PlaceAdapter);
                    listPlace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                      // Toast.makeText(MainActivity.this, PlaceModels[i].getTitle(), Toast.LENGTH_SHORT).show();
                                }
                        });

                }
        }
}

}
//     void executeWebService(String url) {
//   RequestQueue queue = Volley.newRequestQueue(this);
// Request a string response from the provided URL.
//   StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//  new Response.Listener<String>() {
// @Override
//public void onResponse(String response) {
//
//      try {
//
//      JSONObject jsonObject = new JSONObject(response);
//    JSONArray jsonArray = jsonObject.getJSONArray("results");
//mTextView.setText(jsonArray.toString());

// final PlaceModels[] placeModel;
//    placeModel = new Gson().fromJson(jsonArray.toString(), PlaceModels[].class);
// Adapter_places movieAdapter = new Adapter_places(MainActivity.this, placeModel);
//  listPlace.setAdapter(movieAdapter);
// listPlace.setOnItemClickListener(new AdapterView.OnItemClickListener() {

// @Override
// public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
// }
//    });
//     } catch (JSONException e) {
//   e.printStackTrace();
        }
//    }
//    }, new Response.ErrorListener() {
// @Override
// public void onErrorResponse(VolleyError error) {


//   }
//   });
//   queue.add(stringRequest);
//    }

//  private class ErrorListener {
//  }
// }

