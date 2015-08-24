package com.justanotherproject.botischileapi16;


import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

public class GoogleAPI implements GoogleApiClient.ConnectionCallbacks,    GoogleApiClient.OnConnectionFailedListener {

    private Context context;
    private GoogleApiClient mGoogleApiClient;
    private boolean isConnected;
    // Location
    Location mLastLocation;

    public GoogleAPI(Context c) {
        context = c;
    }


    protected synchronized void buildGoogleApiClient() {
        Log.d("MYTAG", "BUILDING GOOGLE API");
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    public boolean Connect(){
        if (!mGoogleApiClient.isConnected())
            mGoogleApiClient.connect();
        else
            Log.d("MYTAG","GoogleApiClient is already connected!");
        return isConnected;
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.d("MYTAG", "GOOGLE API CONNECTED!");
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
        }
    }

    public double getLat(){
        return mLastLocation.getLatitude();
    }
    public double getLon(){
        return mLastLocation.getLongitude();
    }
    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

}