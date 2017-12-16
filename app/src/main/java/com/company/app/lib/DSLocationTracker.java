package com.company.app.lib;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class DSLocationTracker
    implements LocationListener, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {
  private boolean tracking;

  private LocationRequest request;

  private GoogleApiClient mGoogleApiClient;

  private DSLocationEventHandler handler;

  public DSLocationTracker(Context context, DSLocationEventHandler handler) {
    mGoogleApiClient =
        new GoogleApiClient.Builder(context)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .addApi(LocationServices.API)
            .build();

    tracking = false;

    this.handler = handler;
  }

  public void stopTracking() {
    if (tracking) {
      LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
      tracking = false;
      mGoogleApiClient.disconnect();
      this.request = null;
    }
  }

  @Override
  public void onConnectionSuspended(int i) {}

  public void trackOnce(int priority) {
    final DSLocationEventHandler originalHandler = handler;

    this.handler =
        new DSLocationEventHandler() {
          @Override
          public void onLocationChanged(Location location) {
            originalHandler.onLocationChanged(location);
            DSLocationTracker.this.stopTracking();
            DSLocationTracker.this.handler = originalHandler;
          }

          @Override
          public void onFailure() {
            originalHandler.onFailure();
            DSLocationTracker.this.stopTracking();
            DSLocationTracker.this.handler = originalHandler;
          }
        };

    startTracking(10000, 5000, priority);
  }

  public void setHandler(DSLocationEventHandler h) {
    this.handler = h;
  }

  @Override
  public void onLocationChanged(Location location) {
    handler.onLocationChanged(location);
  }

  @Override
  public void onConnected(@Nullable Bundle bundle) {
    try {
      LocationServices.FusedLocationApi.requestLocationUpdates(
          mGoogleApiClient, this.request, this);
      tracking = true;
    } catch (SecurityException ignored) {
    }
  }

  public void startTracking(long interval, long fastestInterval, int priority) {
    if (!tracking) {
      this.request = new LocationRequest();
      this.request.setInterval(interval);
      this.request.setFastestInterval(fastestInterval);
      this.request.setPriority(priority);
      mGoogleApiClient.connect();
    }
  }

  @Override
  public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    handler.onFailure();
  }

  public interface DSLocationEventHandler {
    void onLocationChanged(Location location);

    void onFailure();
  }
}