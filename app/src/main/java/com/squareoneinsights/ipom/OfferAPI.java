package com.squareoneinsights.ipom;

import android.os.AsyncTask;
import android.util.Log;
import com.squareoneinsights.instrumentation.WebUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class OfferAPI extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        String stringUrlLike = "http://%s:9000/api/v1/activity-engine/activity";
        String stringUrl = String.format(stringUrlLike, params[0]);
        String result;
        JSONObject postDataParams = new JSONObject();
        try {
            postDataParams.put("userId", params[1]);
            postDataParams.put("activityName", params[2]);
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
        MainActivity.textViewOffer.setText("");
        super.onPostExecute(result);
        String offerDetails = "";
        try {
            JSONObject jsonObject = new JSONObject(result);
            offerDetails = jsonObject.get("offerDetail").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        MainActivity.textViewOffer.setText(offerDetails.toString());
    }
}
