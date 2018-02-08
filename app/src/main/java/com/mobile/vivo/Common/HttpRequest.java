package com.mobile.vivo.Common;

import android.content.Context;
import android.util.Base64;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.mobile.vivo.Common.interfaces.Statics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by android on 12/01/2018.
 */

public class HttpRequest {
    private String TAG = "HttpRequest";

    public void menuappvivo(final Context context, final Map<String, String> params) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Statics.menuappvivo,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response == null) response = "";
                        Log.d(TAG, "menuappvivo response:" + response);
//                        TurnBookDto obj = null;
//                        if (Utils.isResponseObject(response)) {
//                            try {
//                                obj = new Gson().fromJson(response, TurnBookDto.class);
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//
//                        if (obj != null && obj.Code == Statics.HTTP_SUCCESS)
//                            callBack.onSuccess(obj.turnBookDtos);
//                        else callBack.onFail();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "menuappvivo:" + error.toString());
//                        callBack.onVolleyError(error);
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("StoreID", "1");

                //returning parameter
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return Const.getHeader();
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                Statics.TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
