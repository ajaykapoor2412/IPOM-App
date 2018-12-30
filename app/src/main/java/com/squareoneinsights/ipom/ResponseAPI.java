package com.squareoneinsights.ipom;

import android.os.AsyncTask;
import com.squareoneinsights.instrumentation.WebUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class ResponseAPI extends AsyncTask<String, Void, String> {

    public static final String IPAddress = "192.168.0.107:9000";
    //public static final String IPAddress = "13.232.208.107:80";

    @Override
    protected String doInBackground(String... params) {


        String stringUrlLike = "http://%s/api/v1/activity-engine/response";
        String stringUrl = String.format(stringUrlLike, IPAddress);
        String result;
        JSONObject postDataParams = new JSONObject();
        try {
            postDataParams.put("activityId", params[0]);
            postDataParams.put("userId", params[1]);
            postDataParams.put("offerDetail", params[2]);
            postDataParams.put("offerResponse", params[3]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            result = WebUtil.SendActivity(stringUrl, postDataParams.toString());
        } catch (Exception ex) {
            result = null;
        }

        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute("");
    }
}
