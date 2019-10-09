package com.lassa97.coffeer.Handler;

import android.widget.Toast;

import com.google.gson.Gson;
import com.lassa97.coffeer.MainActivity;
import com.lassa97.coffeer.Object.PruebaREST;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.nio.charset.StandardCharsets;

public class PruebaResponseHandler extends AsyncHttpResponseHandler {
    private Gson gson;
    private MainActivity activity;

    public PruebaResponseHandler (Gson gson, MainActivity activity) {
        this.gson=gson;
        this.activity = activity;
    }

    @Override
    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
        //Log.d("Hola", responseBody.toString());
        PruebaREST response = this.gson.fromJson(
                new String(responseBody, StandardCharsets.UTF_8),
                PruebaREST.class
        );
        /*activity.setLocalizaciones(response.getLocalizaciones());
        activity.crearListView();*/
        Toast.makeText(activity, response.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
        PruebaREST response = this.gson.fromJson(
                new String(responseBody, StandardCharsets.UTF_8),
                PruebaREST.class
        );
        Toast.makeText(activity, response.getErr(), Toast.LENGTH_SHORT).show();
    }
}
