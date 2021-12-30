package com.example.myproject.api;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ApiServices {


    Context context;


    public ApiServices(Context context){

        this.context=context;
    }


    public interface  OnRecive{

        void onSuc(JSONArray jsons);
        void onError(String msg);

    }

    public interface  OnReciveWithOject{
        void onSuc(JSONObject jsons);

        void onError(String msg);

    }



    public void EnglishToFarsi(final String txt, final OnReciveWithOject onRecive) {



        HashMap<String,Object> param =new HashMap<String,Object>();



        RequestQueue queue = Volley.newRequestQueue(context);
        //  rlWating.setVisibility(View.VISIBLE);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                ApiBase.BASE_URL+ApiBase.STATIC_URL+ApiBase.SEARCH_Q_URL+txt
                        +ApiBase.SEARCH_PARAMS_URL+ApiBase.SEARCH_EN2FR
                ,new JSONObject(param) ,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        //   rlWating.setVisibility(View.GONE);
                        Log.d("MySuc ", response.toString());
                        int statusCode=0;




                        JSONArray json=new JSONArray();
                        onRecive.onSuc(response);




                    }


                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                //   rlWating.setVisibility(View.GONE);
                VolleyLog.d("MyError " + error.toString());
                String er=error.toString();
                if(er.contains("volley.NoConnectionError")){
                    Toast.makeText(context, "لطفا اینترنت گوشی خود را بررسی کنی", Toast.LENGTH_LONG).show();

                }
                else if(er.contains("volley.ServerError")){

                    Toast.makeText(context, "سرور در دسترس نیست ", Toast.LENGTH_LONG).show();


                }

            }
        })



        {

            /**
             * Passing some request headers
             * */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");


                return headers;
            }






        };

        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(jsonObjReq);



//return  items;
    }


    public void FarsiToEnglish(final String txt, final OnReciveWithOject onRecive) {



        HashMap<String,Object> param =new HashMap<String,Object>();



        RequestQueue queue = Volley.newRequestQueue(context);
        //  rlWating.setVisibility(View.VISIBLE);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                ApiBase.BASE_URL+ApiBase.STATIC_URL+ApiBase.SEARCH_Q_URL+txt
                        +ApiBase.SEARCH_PARAMS_URL+ApiBase.SEARCH_FR2EN
                ,new JSONObject(param) ,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        //   rlWating.setVisibility(View.GONE);
                        Log.d("MySuc ", response.toString());
                        int statusCode=0;




                        JSONArray json=new JSONArray();
                        onRecive.onSuc(response);




                    }


                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                //   rlWating.setVisibility(View.GONE);
                VolleyLog.d("MyError " + error.toString());
                String er=error.toString();
                if(er.contains("volley.NoConnectionError")){
                    Toast.makeText(context, "لطفا اینترنت گوشی خود را بررسی کنی", Toast.LENGTH_LONG).show();

                }
                else if(er.contains("volley.ServerError")){

                    Toast.makeText(context, "سرور در دسترس نیست ", Toast.LENGTH_LONG).show();


                }

            }
        })



        {

            /**
             * Passing some request headers
             * */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");


                return headers;
            }






        };

        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(jsonObjReq);



//return  items;
    }






}
