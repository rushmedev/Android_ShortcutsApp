package com.company.app.lib.google;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class GoogleDistanceMatrixApi {
  private static Service service =
      new Retrofit.Builder()
          .baseUrl("https://maps.googleapis.com/")
          .addConverterFactory(ScalarsConverterFactory.create())
          .build()
          .create(Service.class);

  private static String API_KEY = null;

  public static boolean setApiKey(Context context) {
    try {
      ApplicationInfo ai =
          context
              .getPackageManager()
              .getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
      Bundle bundle = ai.metaData;
      String apiKey = bundle.getString("com.google.android.geo.API_KEY");
      if (apiKey != null) {
        API_KEY = apiKey;
        return true;
      }
    } catch (PackageManager.NameNotFoundException e) {
      Log.e(
          "GOOGLE-DISTANCE-MATRIX-API",
          "Failed to load meta-data, NameNotFound: " + e.getMessage());
    } catch (NullPointerException e) {
      Log.e(
          "GOOGLE-DISTANCE-MATRIX-API", "Failed to load meta-data, NullPointer: " + e.getMessage());
    }

    return false;
  }

  public static void getTimeAndDistance(
      String origin,
      String destination,
      String mode,
      String units,
      final DistanceCallback callback) {
    if (API_KEY == null || API_KEY.isEmpty()) {
      callback.onFailure("Google Places API Key not set.");
    } else {
      Callback<String> baseCallback =
          new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
              if (response.code() == 200) {
                JsonParser parser = new JsonParser();
                try {
                  JsonObject obj = parser.parse(response.body()).getAsJsonObject();
                  JsonObject element =
                      obj.getAsJsonArray("rows")
                          .get(0)
                          .getAsJsonObject()
                          .getAsJsonArray("elements")
                          .get(0)
                          .getAsJsonObject();
                  Integer duration = element.getAsJsonObject("duration").get("value").getAsInt();
                  Double distance = element.getAsJsonObject("distance").get("value").getAsDouble();
                  ResponseModel model = new ResponseModel(duration, distance);
                  callback.onSuccess(model);
                } catch (Exception e) {
                  callback.onFailure("Could not parse Google Distance Matrix API Response.");
                }
              } else {
                callback.onFailure("Google Distance Matrix API call was unsuccessful.");
              }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
              callback.onFailure("Google Distance Matrix API call was unsuccessful.");
            }
          };
      service.postDistanceMatrix(origin, destination, mode, units, API_KEY).enqueue(baseCallback);
    }
  }

  public interface DistanceCallback {
    void onSuccess(ResponseModel response);

    void onFailure(String reason);
  }

  private interface Service {
    @Headers({"Accept: application/json"})
    @POST("maps/api/distancematrix/json")
    Call<String> postDistanceMatrix(
        @Query("origins") String origins,
        @Query("destinations") String destinations,
        @Query("mode") String mode,
        @Query("units") String units,
        @Query("key") String apiKey);
  }

  public static class ResponseModel {
    public Double distance;

    public Integer duration;

    public ResponseModel() {
      duration = 0;

      distance = 0D;
    }

    public ResponseModel(Integer du, Double di) {
      this.duration = du;

      this.distance = di;
    }
  }
}