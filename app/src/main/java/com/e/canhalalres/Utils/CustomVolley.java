package com.e.canhalalres.Utils;

import android.content.Context;


import androidx.annotation.NonNull;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

public class CustomVolley {
    RequestQueue requestQueue;
    private static CustomVolley instance=new CustomVolley();

    private CustomVolley(){}

    public static CustomVolley getInstance(){
        return instance;
    }

    public interface IRequestCallbacks{
        void onStringResponse(String response);
        void onErrorResponse(VolleyError volleyError);
    }

    public void getVolley(@NonNull Context context, @NonNull final String url, @NonNull final Map<String, String> headers, @NonNull final String tag, @NonNull final IRequestCallbacks requestCallbacks){
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (requestCallbacks!=null){
                    requestCallbacks.onStringResponse(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (requestCallbacks!=null){
                    requestCallbacks.onErrorResponse(error);
                }
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }
        };
        requestQueue= Volley.newRequestQueue(context);
        stringRequest.setShouldCache(false);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        stringRequest.setTag(tag);
        requestQueue.add(stringRequest);
    }

    public void postVolley(@NonNull Context context, @NonNull final String url, @NonNull final Map<String, String> params, @NonNull final String tag, @NonNull final IRequestCallbacks requestCallbacks){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (requestCallbacks != null) {
                    requestCallbacks.onStringResponse(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (requestCallbacks != null) {
                    requestCallbacks.onErrorResponse(error);
                }
            }
        }) {
            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };

        requestQueue = Volley.newRequestQueue(context);
        stringRequest.setShouldCache(false);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(90000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        stringRequest.setTag(tag);
        requestQueue.add(stringRequest);
    }
    public void getCancelVolley(@NonNull Context context, @NonNull final String url, @NonNull final Map<String, String> headers, @NonNull final String tag, @NonNull final IRequestCallbacks requestCallbacks){
        if (requestQueue!=null){
            requestQueue.cancelAll(tag);
        }
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (requestCallbacks!=null){
                    requestCallbacks.onStringResponse(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (requestCallbacks!=null){
                    requestCallbacks.onErrorResponse(error);
                }
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }
        };
        requestQueue= Volley.newRequestQueue(context);
        stringRequest.setShouldCache(false);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        stringRequest.setTag(tag);
        requestQueue.add(stringRequest);
    }
}
