package com.justanotherproject.botischileapi16;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment
        extends Fragment
{

    MapView mapView;
    GoogleMap map;
    //GoogleAPI mGoogleApiClient;
//    LatLng newLatLng;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        super.onCreate(savedInstanceState);
//        mGoogleApiClient = new GoogleAPI(getActivity());
//        mGoogleApiClient.buildGoogleApiClient();
    }

//    @Override
//    public void onStart(){
//        super.onStart();
//        mGoogleApiClient.Connect();
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.map_layout, container, false);

        // Gets the MapView from the XML layout and creates it
        mapView = (MapView) v.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        // Gets to GoogleMap from the MapView and does initialization stuff
        map = mapView.getMap();
        map.getUiSettings().setMyLocationButtonEnabled(true);
        map.setMyLocationEnabled(true);

        //Add a marker
        map.addMarker(new MarkerOptions().position(
                new LatLng(-33.4556327, -70.655571)).icon(
                BitmapDescriptorFactory.defaultMarker()).title("Test Title").snippet("Test Detail"));


        // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
            MapsInitializer.initialize(this.getActivity());


//        if (mLastLocation != null) {
//
//            // latitude and longitude
//            LatLng lat = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
//
//            //double latitude = 17.385044;
//            //double longitude = 78.486671;
//            //LatLng lat = new LatLng(latitude,longitude);
//
//            // create marker
//
//            MarkerOptions marker = new MarkerOptions().position(
//                    lat).title("Hello Maps");
//
//            // Changing marker icon
//            marker.icon(BitmapDescriptorFactory
//                    .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
//
//            // adding marker
//            map.addMarker(marker);
//
//            CameraPosition cameraPosition = new CameraPosition.Builder()
//                    .target(lat).zoom(12).build();
//
//
//            map.animateCamera(CameraUpdateFactory
//                    .newCameraPosition(cameraPosition));
//
//        }


        //Starting position
        map.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(-36.4370562,-71.9207452) , 12) );

//

        //Move the camera to a determinate position
        // Updates the location and zoom of the MapView
        //CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(-33.4556327, -70.655571), 12);
       // map.animateCamera(cameraUpdate);


//        newLatLng = new LatLng(mGoogleApiClient.getLat(), mGoogleApiClient.getLon());

//        map.moveCamera( CameraUpdateFactory.newLatLngZoom(newLatLng, 12));

        return v;
    }

//    protected synchronized void buildGoogleApiClient() {
//
//        mGoogleApiClient = new GoogleApiClient.Builder(this.getActivity())
//                .addConnectionCallbacks(this)
//                .addOnConnectionFailedListener(this)
//                .addApi(LocationServices.API)
//                .build();
//    }

    @Override
    public void onResume() {

        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}