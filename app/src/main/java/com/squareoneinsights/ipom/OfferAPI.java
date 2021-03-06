package com.squareoneinsights.ipom;

import android.os.AsyncTask;
import android.util.Log;
import com.squareoneinsights.instrumentation.WebUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class OfferAPI extends AsyncTask<String, Void, String> {

    public static final String IPAddress = "192.168.0.107:9000";
    //public static final String IPAddress = "13.232.208.107:80";

    @Override
    protected String doInBackground(String... params) {
        String stringUrlLike = "http://%s/api/v1/activity-engine/activity";
        String stringUrl = String.format(stringUrlLike, IPAddress);
        String result;
        JSONObject postDataParams = new JSONObject();
        try {
            postDataParams.put("userId", params[0]);
            postDataParams.put("activityName", params[1]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            result = WebUtil.SendActivity(stringUrl, postDataParams.toString());
        } catch (Exception ex) {
            Log.d("OfferAPI_Error", ex.getMessage());
            result = null;
        }

        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
//        String offerDetails = "";
//        try {
//            JSONObject jsonObject = new JSONObject(result);
//            offerDetails = jsonObject.get("offerDetail").toString();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
    }
}
